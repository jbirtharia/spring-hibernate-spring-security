package com.spring.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

//This class is responsible for managing authentication part of spring security
@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    @SuppressWarnings("deprecation")
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        *//*This will login using in line memory authentication.
        * This will create automatic login page,
        * which is spring security login page because we have not provided our own custom login page.
        * Only following users can login from that page.
        * So this method only responsible for providing inline memory and data*//*

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(users.username("jayendra").password("123").roles("EMPLOYEE","ADMIN"))
                .withUser(users.username("sachin").password("123").roles("EMPLOYEE","MANAGER"))
                .withUser(users.username("dhoni").password("123").roles("EMPLOYEE"));
    }
*/

    /* Spring security with UserDetailService. Spring will use following method for db based authentication. */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }



    /*This method will configure security of web paths in application like login, logout etc.
    * This method will handle all login and logout url's.
    * You can give custom login and logout page here. So
    * spring security will not use its own login page it will use your's custom login page.*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()

                /*Following match for public access url. We have enabled security to all urls, so
                * we have to mention those urls which are publicly accessible by following way.*/
                .antMatchers("/signup").permitAll()

                /*Following we have provided access URL based on the user role.
                * Each user has roles and based on that role he can access the urls
                * based on their roles.*/
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/managers/**").hasRole("MANAGER")
                .antMatchers("/admin/**").hasRole("ADMIN")

                //.anyRequest().authenticated()
                .and()
                .formLogin()

                //Custom Login Page
                .loginPage("/showMyLoginPage")


                /* It is login processing url. We dont need to write controller mapping
                 * for this url. Spring will automatically configure that url.
                 * We just need to pass login data (from login page like username and password)
                 * to that url. Spring will automatically handle the
                 * login logic by using this url.*/
                .loginProcessingUrl("/authenticateUser")
                .permitAll()

                /* Add logout support for default url logout.
                * Logout url will be handled by spring security filters.
                * We get it free...no coding required. It will also invalidate Http session
                * and remove cookies, it will send user to login page.*/
                .and()
                .logout().permitAll().and()

                /* Landing page for any exception occurred. */
                .exceptionHandling().accessDeniedPage("/accessDenied");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        /*Due to the following code spring security will ignore all static files like js and css file.
        * Spring security usually blocks static files, so we have to tell spring security that ignores
        * resources directory under which all static files are placed. So due to following code spring security
        * resources folder and static files are accessible.*/
        web.ignoring().antMatchers("/resources/**");
    }
}
