package com.azamma.conexa.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@code JwtAuthConverter}
 * Implementa un {@link Converter} que convierte un token JWT en un objeto de autenticación.
 * <p>
 * Esta clase se encarga de extraer y combinar las autoridades de un token JWT, las cuales son usadas
 * para definir los permisos y roles de un usuario en la aplicación.
 * </p>
 *
 * <p>
 * Utiliza la configuración del token JWT para obtener el nombre del principio (subjeto) y roles adicionales
 * específicos del recurso.
 * </p>
 *
 * <p>
 * {@link JwtAuthConverter} también permite la configuración del atributo del principio y el ID del recurso
 * a través de propiedades externas definidas en la configuración de la aplicación.
 * </p>
 *
 * @author Agustin Zammarrelli
 */
@Component
public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    // Convertidor para extraer autoridades estándar del token JWT
    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter =
            new JwtGrantedAuthoritiesConverter();

    // Atributos configurables para ajustar el comportamiento del convertidor
    @Value("${jwt.auth.converter.principle-attribute}")
    private String principleAttribute;
    @Value("${jwt.auth.converter.resource-id}")
    private String resourceId;

    /**
     * Convierte un token JWT en un objeto {@link AbstractAuthenticationToken}.
     * <p>
     * Este método combina las autoridades estándar del token JWT con los roles específicos del recurso
     * extraídos del claim "resource_access".
     * </p>
     *
     * @param jwt El token JWT que se convertirá en un objeto de autenticación.
     * @return Un {@link JwtAuthenticationToken} que representa al usuario autenticado con sus autoridades.
     */
    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        // Combina las autoridades estándar y los roles específicos del recurso
        Collection<GrantedAuthority> authorities = Stream.concat(
                jwtGrantedAuthoritiesConverter.convert(jwt).stream(),
                extractResourceRoles(jwt).stream()
        ).collect(Collectors.toSet());

        // Crea y devuelve un token de autenticación con las autoridades combinadas
        return new JwtAuthenticationToken(
                jwt,
                authorities,
                getPrincipleClaimName(jwt)
        );
    }

    /**
     * Obtiene el nombre del principio (subjeto) desde el token JWT.
     * <p>
     * Si se ha configurado un atributo específico para el principio, se usa ese nombre de atributo. De lo
     * contrario, se usa el nombre de atributo predeterminado "sub".
     * </p>
     *
     * @param jwt El token JWT del cual se extrae el nombre del principio.
     * @return El valor del claim del principio.
     */
    private String getPrincipleClaimName(Jwt jwt) {
        String claimName = JwtClaimNames.SUB;
        if (principleAttribute != null) {
            claimName = principleAttribute;
        }
        return jwt.getClaim(claimName);
    }

    /**
     * Extrae los roles específicos del recurso del token JWT.
     * <p>
     * Obtiene los roles definidos en el claim "resource_access" y los convierte en autoridades de Spring
     * Security, prefijando con "ROLE_".
     * </p>
     *
     * @param jwt El token JWT del cual se extraen los roles del recurso.
     * @return Una colección de {@link GrantedAuthority} basada en los roles del recurso.
     */
    private Collection<? extends GrantedAuthority> extractResourceRoles(Jwt jwt) {
        Map<String, Object> resourceAccess;
        Map<String, Object> resource;
        Collection<String> resourceRoles;

        // Verifica si el claim "resource_access" está presente
        if (jwt.getClaim("resource_access") == null) {
            return Collections.emptySet();
        }

        // Obtiene el acceso al recurso específico del JWT
        resourceAccess = jwt.getClaim("resource_access");

        if (resourceAccess.get(resourceId) == null) {
            return Collections.emptySet();
        }

        // Extrae los roles del recurso
        resource = (Map<String, Object>) resourceAccess.get(resourceId);
        resourceRoles = (Collection<String>) resource.get("roles");

        // Convierte los roles a autoridades de Spring Security
        return resourceRoles
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toSet());
    }
}
