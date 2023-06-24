package proyecto.pontificia.elp.mi.registromatricula.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfigurer {

    @Bean
    WebMvcConfigurer CorsConfigurer(){
        return new WebMvcConfigurer(){
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry
                        .addMapping("/api/**")
                        .allowedOrigins("*")
                        .allowedMethods("*");
                registry
                        .addMapping("/login")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .exposedHeaders("*");
            }
        };
    }
}
