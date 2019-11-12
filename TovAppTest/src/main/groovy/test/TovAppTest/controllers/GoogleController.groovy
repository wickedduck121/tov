package test.TovAppTest.controllers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import java.security.Principal

@RestController
class GoogleController {
    @RequestMapping(value = "/user")
    public Principal user(Principal principal) {
        return principal;
    }

}
