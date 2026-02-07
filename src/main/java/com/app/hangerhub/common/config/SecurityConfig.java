package com.app.hangerhub.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //? to overwrite AuthenticationProvider in app
    @Bean
    public AuthenticationProvider authenticationProvider (
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder
    ) {
        //? DaoAuthenticationProvider implement AuthenticationProvider
        //? i can't user AuthenticationProvider Direct because it's an Interface
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        //! can't get use in production ... deprecated
        provider.setPasswordEncoder(passwordEncoder);
         return provider;
    }


}
