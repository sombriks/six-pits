package six.pits.game.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")//
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")//
        .allowedHeaders("Accept", "Accept-Language", "Content-Language", "Content-Type")//
        .allowedOrigins("*");
  }
}