package org.example.employee_management.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwagConfig {

    @Bean
    public OpenAPI employeeManagementAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Employee Management System API")
                        .version("1.0")
                        .description("REST API for managing employees, tasks, and leave requests.")
                        .contact(new Contact()
                                .name("Darius")
                                .url("https://github.com/vegpulao")));
    }
}