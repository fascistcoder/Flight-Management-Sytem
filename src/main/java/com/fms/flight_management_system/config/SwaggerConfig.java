package com.fms.flight_management_system.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.Generated;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 21/05/22
 */
@Generated
@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI fmsOpenAPI() {
		return new OpenAPI().path("*", new PathItem())
				.info(new Info()
						.title("Flight Management System")
						.version("1")
						.license(new License().name("Apache 2.0").url("https://github.com/fascistcoder")));
	}

}
