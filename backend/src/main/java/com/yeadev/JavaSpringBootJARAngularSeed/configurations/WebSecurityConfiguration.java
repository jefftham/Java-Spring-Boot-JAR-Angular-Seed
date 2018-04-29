package com.yeadev.JavaSpringBootJARAngularSeed.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;



/*
 * This configuration only apply for prod.
 * */

@Slf4j
@Configuration
@EnableWebSecurity
@Profile({"preprod","prod"})
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

   @Autowired
   public WebSecurityConfiguration(JdbcTemplate jdbcTemplate) {
        this.dataSource = jdbcTemplate.getDataSource();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // visitors can access all except ...
        http
                .authorizeRequests()
                // .antMatchers("/jdbc/**", "/returnJson").authenticated()
                .antMatchers("/protected/**").authenticated()
                .antMatchers("/h2/**").permitAll()
                .anyRequest().permitAll()
            .and()
                .formLogin()
                //.loginPage("/login")
                .permitAll()
            .and()
                .logout()
                .permitAll()
            .and()
                // .exceptionHandling().accessDeniedPage("/access-denied");

        ;


        /* // other example
         http.authorizeRequests()
			    .antMatchers("/").hasRole("EMPLOYEE")
			    .antMatchers("/leaders/**").hasRole("MANAGER")
			    .antMatchers("/systems/**").hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			    .logout().permitAll()
			.and()
			    .exceptionHandling().accessDeniedPage("/access-denied");
		*/
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // use database
        auth.jdbcAuthentication().dataSource(dataSource)
               .usersByUsernameQuery("select username, password, enabled from users where username=?")
               .authoritiesByUsernameQuery("select username, role  from user_roles  where username=?")
               //.passwordEncoder(new BCryptPasswordEncoder())
                ;
    }


}
