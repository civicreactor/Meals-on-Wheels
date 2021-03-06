package com.meals.on.wheels;

import org.dozer.DozerBeanMapper;
import org.h2.server.web.WebServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


import java.util.Arrays;
import java.util.List;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@SpringBootApplication
@EnableSwagger2
@Configuration
public class MealsOnWheelsApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(MealsOnWheelsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MealsOnWheelsApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean h2servletRegistration(){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			if(LOGGER.isDebugEnabled()) {

				LOGGER.debug("Let's inspect the beans provided by Spring Boot:");

				String[] beanNames = ctx.getBeanDefinitionNames();
				Arrays.sort(beanNames);
				for (String beanName : beanNames) {
					LOGGER.debug(beanName);
				}
			}
		};
	}

	@Bean
	public CorsFilter corsFilter() {

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true); // you USUALLY want this
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}


	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex(".*"), regex("/.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("MealsOnWheels API")
				.description("API Reference for Meals on Wheels")
				.termsOfServiceUrl("https://skillsmatter.com/groups/10587-civic-reactor")
				.contact("https://skillsmatter.com/groups/10587-civic-reactor").license("Civic Reactor")
				.licenseUrl("https://skillsmatter.com/groups/10587-civic-reactor").version("1.0").build();
	}


	@Bean(name = "org.dozer.Mapper")
	public DozerBeanMapper dozerBean() {
		/*
		List<String> mappingFiles = Arrays.asList(
				"dozer-global-configuration.xml",
				"dozer-bean-mappings.xml",
				"more-dozer-bean-mappings.xml"
		);
		*/

		DozerBeanMapper dozerBean = new DozerBeanMapper();
		//dozerBean.setMappingFiles(mappingFiles);
		return dozerBean;
	}

}
