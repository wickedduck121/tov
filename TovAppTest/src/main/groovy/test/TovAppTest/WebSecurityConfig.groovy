package test.TovAppTest

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import test.TovAppTest.rep.UserRepository

import java.util.logging.Logger;
@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        new BCryptPasswordEncoder()
    }

    @Autowired
    PasswordEncoder passwordEncoder



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("config got")

        http
                .csrf().disable()
                .formLogin()
                .loginProcessingUrl('/api/login')
                .successHandler { req, res, e -> res.status = 200 }
                .failureHandler { req, res, e -> res.status = 401 }

                .and()
                .exceptionHandling()
                .accessDeniedHandler { req, res, e -> res.status = 401 }

                .and()
                .logout()

                .and()
                .authorizeRequests()
                .anyRequest().authenticated()

                .and().httpBasic()

       /* http
                .authorizeRequests()
                .antMatchers("/", "/api/login").permitAll()
                .anyRequest().permitAll()

                http.formLogin()
                .loginPage("/api/login").loginProcessingUrl('/api/login')
                .permitAll()
                .and()
                .logout()
                .permitAll();*/


    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder)
    }



//    @Configuration
//    protected static class AuthenticationConfiguration extends
//            GlobalAuthenticationConfigurerAdapter {
//
//
//        @Autowired
//        void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(MyUserDetailService).passwordEncoder(bCryptPasswordEncoder());
//        }
//
//        @Override
//        public void init(AuthenticationManagerBuilder auth) throws Exception {
//            auth
//                    .inMemoryAuthentication()
//                    .withUser("user").password("password").roles("USER");
//        }
//
//    }

    @Bean
    UserDetailsService userDetailsService() {
        Logger log = Logger.getLogger(TovAppTestApplication.class.name)
        log.info("bean got")
        return new MyUserDetailService();
    }
    /*@Autowired
    private MyUserDetailService userDetailsService;*/
}




