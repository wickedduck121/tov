package test.TovAppTest

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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import test.TovAppTest.rep.UserRepository

import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        Logger log = Logger.getLogger(TovAppTestApplication.class.name)
        log.info("config got")

        http
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .anyRequest().authenticated()

                http.formLogin()
                .loginPage("/api/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();


    }

    @Configuration
    protected static class AuthenticationConfiguration extends
            GlobalAuthenticationConfigurerAdapter {


        @Autowired
        void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(MyUserDetailService).passwordEncoder(bCryptPasswordEncoder());
        }

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .inMemoryAuthentication()
                    .withUser("user").password("password").roles("USER");
        }

    }

    @Bean
    UserDetailsService userDetailsService()
    {
        Logger log = Logger.getLogger(TovAppTestApplication.class.name)
        log.info("bean got")
        return new MyUserDetailService();
    }
    /*@Autowired
    private MyUserDetailService userDetailsService;*/
    }




