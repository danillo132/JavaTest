package br.com.javaTest.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Classe de configuração do Swagger para documentar a API REST
 * @author Danillo Santiago
 * @since jul 2022
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket freteApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.javaTest")).paths(PathSelectors.ant("/**"))
				.build().apiInfo(metaInfo());
	}

	public ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo("API REST SigaBem",
				"API REST responsável por calcular prazo de entrega e preço do frete", "1.0", "Terms of Service",
				new Contact("Danillo Santiago", "https://github.com/danillo132",
						"danillosantiago32@gmail.com"),
				"Apache License Version 2.0", "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>());
		return apiInfo;
	}
}
