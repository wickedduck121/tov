package test.TovAppTest.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import test.TovAppTest.entities.User
import test.TovAppTest.rep.UserRepository

@RestController
@RequestMapping("/api/user")
class UserController {

    private final UserRepository repo

    @Autowired
    UserController(UserRepository rp){
        repo=rp;
    }

    @GetMapping
    List<User> list(){
        repo.findAll();
    }

    @GetMapping('/name/{name}')
    User getOneName(@PathVariable('name') String name){
        repo.findByName(name);
    }
    @GetMapping('/email/{email}')
    User getOneEmail(@PathVariable('email') String email){
        repo.findByEmail(email);
    }

    @PostMapping
    User add(@RequestBody User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.pass=passwordEncoder(user.pass);
        repo.save(user);
    }

    @DeleteMapping('{name}')
    delete(@PathVariable('name') User user){
        repo.delete(user);
    }

}
