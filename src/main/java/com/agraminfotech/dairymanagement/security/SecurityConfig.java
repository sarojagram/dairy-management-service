package com.agraminfotech.dairymanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userService")
    @Autowired private UserDetailsService userDetailsService;

    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired private JWTRequestFilter jwtRequestFilter;

    @Autowired
    private void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // We don't need CSRF
        httpSecurity.cors().and().csrf().disable()
                // don't authenticate this particular request.
                .authorizeRequests().antMatchers("/login").permitAll()
                .and().authorizeRequests().antMatchers("/root/user/save").permitAll()
                .antMatchers("/admin/**").access("hasAuthority('ADMIN')")
                .antMatchers(HttpMethod.POST,"/admin/**").hasAuthority("ADMIN").
                // all other requests need to be authenticated.
                anyRequest().authenticated()
                .and().
                // make sure we use stateless session; session won't be used to
                // store user's state.
                 exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);


    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean () throws Exception {return
            super.authenticationManagerBean ();
    }
}
