package com.azamma.conexa.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

/**
 * {@code SecurityConfig}
 * Configuración de seguridad para la aplicación que utiliza Spring Security.
 * <p>
 * Esta clase configura la seguridad web y de métodos, habilita la autenticación mediante JWT (JSON Web Token),
 * y define políticas de manejo de sesión.
 * </p>
 * <p>
 * Utiliza {@link JwtAuthConverter} para convertir JWT en objetos de autenticación de Spring Security.
 * </p>
 *
 * @author Agustin Zammarrelli
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthConverter jwtAuthConverter; // Conversor de JWT a autenticación

    /**
     * Configura el {@link SecurityFilterChain} para definir las reglas de seguridad.
     * <p>
     * Esta configuración desactiva la protección CSRF (Cross-Site Request Forgery), permite todas las solicitudes
     * siempre que estén autenticadas, y configura el manejo de JWT para la autenticación. Además, establece la política
     * de creación de sesión como {@link SessionCreationPolicy#STATELESS} para que la aplicación no mantenga estado de sesión.
     * </p>
     *
     * @param http La instancia de {@link HttpSecurity} para configurar la seguridad HTTP.
     * @return Una instancia de {@link SecurityFilterChain} configurada con las reglas de seguridad.
     * @throws Exception Si ocurre un error al configurar la seguridad.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configura la seguridad HTTP
        http
                .csrf()
                .disable() // Desactiva la protección CSRF
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated(); // Requiere autenticación para todas las solicitudes

        // Configura el manejo de JWT para la autenticación
        http
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthConverter);

        // Configura la política de manejo de sesión
        http
                .sessionManagement()
                .sessionCreationPolicy(STATELESS); // No mantiene estado de sesión

        return http.build(); // Devuelve la configuración de seguridad construida
    }
}
