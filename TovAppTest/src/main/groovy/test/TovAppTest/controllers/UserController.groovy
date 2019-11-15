package test.TovAppTest.controllers


import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*
import test.TovAppTest.Services.RepositoryService
import test.TovAppTest.entities.User
import test.TovAppTest.rep.UserRepository

@RestController
@RequestMapping("/api/user")
@Slf4j
class UserController {

    private final UserRepository repo

    @Autowired
    RepositoryService stus

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
        User user = repo.findByName(name)
        log.info('name: '+name)
        user
    }
    @GetMapping('/email/{email}')
    User getOneEmail(@PathVariable('email') String email){
        repo.findByEmail(email);
    }

    @PostMapping
    User add(@RequestBody User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.pass=passwordEncoder(user.pass)
        repo.save(user);
    }

    @DeleteMapping('{name}')
    delete(@PathVariable('name') User user){
        repo.delete(user);
    }

    /*@PutMapping('/updateshop/{name}')
    updateShops(@PathVariable('name') String username,
                @RequestBody String shop_name){
        User user = stus.getUser(username)
        Shop shop = stus.getShop(shop_name)
        user.shops.add(shop)
    }*/

   /* @GetMapping('/usershops/{name}')
        Set<Shop> getShops(@PathVariable('name') String username )
    {
        User user = stus.getUser(username)
        user.shops
    }*/

}
