package com.yeadev.JavaSpringBootJARAngularSeed;

import java.util.Collections;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class JavaSpringBootJarAngularSeedApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringBootJarAngularSeedApplication.class, args);
    }

    // map all unknown path to angular frontend, let angular to handle it.
    @Bean
    public ErrorViewResolver supportPathBasedLocationStrategyWithoutHashes() {
        return (request, status, model) -> status == HttpStatus.NOT_FOUND
                ? new ModelAndView("index.html", Collections.emptyMap(), HttpStatus.OK)
                : null;
    }

    // the following code is not needed, it just output the name of the bean which bundle in Spring Boot
    /*
        @Bean
        public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
            return args -> {

                System.out.println("Let's inspect the beans provided by Spring Boot:");

                String[] beanNames = ctx.getBeanDefinitionNames();
                Arrays.sort(beanNames);
                for (String beanName : beanNames) {
                    System.out.println("beanName = " +beanName);
                }

            };
        }
     */
}
