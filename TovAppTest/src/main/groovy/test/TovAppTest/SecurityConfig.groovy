package test.TovAppTest



/*import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import test.TovAppTest.entities.User
import test.TovAppTest.rep.UserRepository

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().mvcMatchers("/").permitAll().anyRequest().authenticated().and().csrf().disable();

    }

    @Bean
    PrincipalExtractor principalExtractor(UserRepository userRepository){
        return { map ->
            return new User();
        }
    }
}
*/