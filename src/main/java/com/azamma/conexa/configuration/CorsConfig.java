package com.azamma.conexa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * {@code CorsConfig}
 * Configura los ajustes de Cross-Origin Resource Sharing (CORS) para la aplicación.
 * <p>
 * Esta configuración permite que la aplicación acepte solicitudes desde cualquier origen y
 * soporte los métodos HTTP especificados. También permite encabezados personalizados y
 * credenciales en las solicitudes CORS.
 * </p>
 *
 * <p>
 * La configuración se aplica a todas las rutas en la aplicación mediante un filtro CORS.
 * </p>
 *
 * @author Agustin Zammarrelli
 */
@Configuration
public class CorsConfig {

    /**
     * Define un {@link CorsFilter} bean que configura los ajustes de CORS para la aplicación.
     * <p>
     * La configuración permite solicitudes desde cualquier origen, soporta los métodos HTTP
     * GET, POST, PUT, DELETE y OPTIONS, y permite encabezados personalizados. También permite
     * credenciales en las solicitudes CORS.
     * </p>
     *
     * @return Un {@link CorsFilter} configurado con los ajustes especificados para manejar
     * las solicitudes CORS en la aplicación.
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Arrays.asList("*")); // Permitir todos los orígenes
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos permitidos
        corsConfig.setAllowedHeaders(Arrays.asList("*")); // Encabezados permitidos
        corsConfig.setAllowCredentials(true); // Permitir credenciales

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsFilter(source);
    }
}
