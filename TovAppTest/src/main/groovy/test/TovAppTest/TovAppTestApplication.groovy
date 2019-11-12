package test.TovAppTest

import org.apache.catalina.startup.ContextConfig
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration
import org.springframework.context.annotation.Configuration
//import org.springframework.security.oauth2.client.test.OAuth2ContextConfiguration
import test.TovAppTest.SecurityConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

import java.util.logging.Logger

//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
//@EnableOAuth2Sso
class TovAppTestApplication {

	static void main(String[] args) {
		Logger log = Logger.getLogger(TovAppTestApplication.class.name)
		log.info("im alive")
		SpringApplication.run(TovAppTestApplication, args)
	}

}
