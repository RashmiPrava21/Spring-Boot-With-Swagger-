package config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.java.springbootstarter.EmployeeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
//@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackageClasses = EmployeeController.class)
@Configuration
public class SwaggerConfig {

    private static final String SWAGGER_API_VERSION = "1.0";
    private static final String LICENSE_TEXT = "License";
    private static final String title = "SpringBoot - Swagger";
    private static final String description = "RESTful Web Services";

    private ApiInfo apiInfo(){

        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .license(LICENSE_TEXT)
                .version(SWAGGER_API_VERSION)
                .build();

    }

    @Bean
    public Docket employeeApi(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/employees")
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.java.springbootstarter"))
//                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

   /* private Predicate<String> paths(){

        return Predicates.and(
                PathSelectors.regex("/employees.*"),
                Predicates.not(PathSelectors.regex("/error.*"))
        );

    }*/

}
