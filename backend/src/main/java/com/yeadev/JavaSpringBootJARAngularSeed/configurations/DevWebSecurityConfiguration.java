package com.yeadev.JavaSpringBootJARAngularSeed.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/*
 * This configuration only apply for dev because it disable csrf and headers checks for h2 database.
 * */

@Configuration
@EnableWebSecurity
@Profile("dev")
public class DevWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // visitors can access all except ...
        http
                .authorizeRequests()
                .antMatchers("/jdbc/**", "/returnJson").authenticated()
                .antMatchers("/h2/**").permitAll()
                .anyRequest().permitAll()
            .and()
                .formLogin()
                //.loginPage("/login")
                .permitAll()
            .and()
                .logout()
                .permitAll();

        // in dev, spring security will block access to h2 console.
        http.csrf().disable();
        http.headers().frameOptions().disable();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // add our users for in memory authentication
        UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("employee").password("test123").roles("USER"))
                .withUser(users.username("manager").password("test123").roles("USER", "MANAGER"))
                .withUser(users.username("admin").password("test123").roles("USER", "ADMIN"));


    }

}
