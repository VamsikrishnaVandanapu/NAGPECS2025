/*
 * package com.nagp.ecs.ecomapp.config.documentation;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.web.servlet.config.annotation.EnableWebMvc; import
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 * 
 * import springfox.documentation.RequestHandler; import
 * springfox.documentation.builders.ApiInfoBuilder; import
 * springfox.documentation.builders.PathSelectors; import
 * springfox.documentation.builders.RequestHandlerSelectors; import
 * springfox.documentation.service.ApiInfo; import
 * springfox.documentation.service.Contact; import
 * springfox.documentation.spi.DocumentationType; import
 * springfox.documentation.spring.web.plugins.Docket; import
 * springfox.documentation.swagger2.annotations.EnableSwagger2;
 * 
 * @Configuration public class SwaggerConfig {
 * 
 * @Bean public Docket productApi() { return new
 * Docket(DocumentationType.SWAGGER_2) .apiInfo(getApiInfo()) .select()
 * .apis(RequestHandlerSelectors.basePackage("com.nagp.ecomapp.config"))
 * .paths(PathSelectors.any()) .build(); }
 * 
 * private ApiInfo getApiInfo() { Contact contact = new Contact("vamsinagpecs",
 * "http://vamsinagpecs.com", "vamsictltest@gmail.com"); return new
 * ApiInfoBuilder() .title("Ecommerce API")
 * .description("Documentation Ecommerce api") .version("1.0.0")
 * .license("Apache 2.0")
 * .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0") .contact(contact)
 * .build(); } }
 */