package com.app.hangerhub.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

//? use to tell that we mark this class as a configuration class on the app
@Configuration
//? use to aware the app that the app stop using the default
//? security and use this class
@EnableWebSecurity
public class SecurityConfig {

    //? create a bean for Security
    //? it's overwrite any propertesß
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) {

        //* Disable CSRF on Security Filter Chain
        http.csrf(customizer -> customizer.disable() );


        //* Make a Filter Chain To Make Sure That Any Request Send To
        //* Me Must Be Authenticated
        http.authorizeHttpRequests(request -> request
                .anyRequest()
                .authenticated() );

        //* enable form for login with enable the Web Security ( For Web Users )
        http.formLogin(Customizer.withDefaults());

        //* enable form for login with enable the Web Security ( For Postman )
        http.httpBasic(Customizer.withDefaults());


        //* build the last version of HTTP-WEB-SECURITY
        return http.build();
    }
}
