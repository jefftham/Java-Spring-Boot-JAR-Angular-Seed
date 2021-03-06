package com.yeadev.JavaSpringBootJARAngularSeed;

import com.example.demo.DemoApplication;
import com.yeadev.JavaSpringBootJARAngularSeed.util.osCommand.OsCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;


// a spring task scheduler that using spring annotation
// ref: https://docs.spring.io/spring/docs/5.0.4.RELEASE/spring-framework-reference/integration.html#scheduling-task-scheduler


@SpringBootApplication
@EnableScheduling
@Slf4j
public class JavaSpringBootJarAngularSeedApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JavaSpringBootJarAngularSeedApplication.class);
	}


    private static Class applicationClass = JavaSpringBootJarAngularSeedApplication.class;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(JavaSpringBootJarAngularSeedApplication.class, args);

        // scheduler a fixed rate task that run every 600 seconds
        /*
            FixedRateScheduler fixedRateScheduler = (FixedRateScheduler) ctx.getBean("fixedRateScheduler");
            fixedRateScheduler.start(new TimerTask() {
                final long start = System.currentTimeMillis();
                int count = 0;

                @Override
                public void run() {
                    log.info("Task invoked - " + (++count) + " - " + (System.currentTimeMillis() - start) + " ms" + " - " + Thread.currentThread());
                }
            }, 1000, 600_000);
        */

        // run os command

        OsCommand osCommand = (OsCommand) ctx.getBean("osCommand");
        final String run = OsCommand.run("ping google.com");

        // send email
        /*
            try {
                ((EmailService) ctx.getBean("emailService")).sendEmail(
                        new Email(
                                "jeff.tham@email.com,jeff.tham@live.com",
                                "jeff.tham@mail.com",
                                "testing 1",
                                "<p>testing 1</p>",
                                true)
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        */
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
