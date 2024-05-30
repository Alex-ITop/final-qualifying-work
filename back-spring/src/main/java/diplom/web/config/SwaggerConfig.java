package diplom.web.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация Swagger. Доступен по адресу /swagger-ui.html
 */
@Configuration
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.application.description}")
    private String appDescription;

    @Value("${spring.application.version}")
    private String appVersion;

    private static final String SCHEME_NAME = "bearerScheme";
    private static final String SCHEME = "Bearer";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(info())
                .components(getComponents())
                .addSecurityItem(getSecurity());
    }

    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/api/**")
                .group("default")
                .build();
    }

    private Info info() {
        return new Info()
                .title(appName)
                .description(appDescription)
                .version(appVersion);
    }

    private Components getComponents() {
        var components = new Components();
        components.addSecuritySchemes(SCHEME_NAME, getSecurityScheme());

        return components;
    }

    private SecurityScheme getSecurityScheme() {
        return new SecurityScheme()
                .name(SCHEME_NAME)
                .type(SecurityScheme.Type.HTTP)
                .scheme(SCHEME);
    }

    private SecurityRequirement getSecurity() {
        return new SecurityRequirement().addList(SCHEME_NAME);
    }
}
