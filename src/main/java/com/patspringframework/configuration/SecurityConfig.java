package com.patspringframework.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by pakyo_000 on 6/6/2016.
 */
@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery("select username, role from authorization where username = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/backoffice/**").hasRole("ADMIN")
//                .antMatchers("/welcome").access("hasRole('ADMIN') and hasRole('USER')")
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/welcome").failureUrl("/login-error")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/index")
                .and()
                .exceptionHandling().accessDeniedPage("/error")
                .and()
                .csrf();
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
