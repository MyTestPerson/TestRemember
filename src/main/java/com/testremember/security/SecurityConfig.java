package com.testremember.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final
    PersistentTokenRepository persistentTokenRepository;

    private final
    UserDetailsService userDetailsService;

    public SecurityConfig(PersistentTokenRepository persistentTokenRepository, UserDetailsService userDetailsService) {
        this.persistentTokenRepository = persistentTokenRepository;
        this.userDetailsService = userDetailsService;
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

                .mvcMatchers("/").permitAll()
                .mvcMatchers("/login", "/registration").anonymous()
                .mvcMatchers("/admin").hasAnyRole("ADMIN")
                .mvcMatchers("/user").hasAnyRole("ADMIN", "USER")

                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")

                .and().csrf().disable()
                .rememberMe()
                .tokenRepository(persistentTokenRepository)
                .rememberMeParameter("remember-me")
                .rememberMeCookieName("_rm")

                .and()
                .logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")

                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

    }


}