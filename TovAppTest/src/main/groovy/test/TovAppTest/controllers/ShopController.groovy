package test.TovAppTest.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import test.TovAppTest.Services.ShoptoUserService
import test.TovAppTest.entities.Shop
import test.TovAppTest.entities.User
import test.TovAppTest.rep.ShopRepository

@RestController
@RequestMapping('api/shops')
class ShopController {

    private final ShopRepository repo

    @Autowired
    ShopController(ShopRepository rp){
        repo=rp;
    }
    @Autowired
    ShoptoUserService stus

@GetMapping
    List<Shop> list(){
    repo.findAll()
}

    @GetMapping("{id}")
    Shop getOneById(@PathVariable("id") String name_local){
        repo.findByName(name_local)
    }

    @PostMapping("{name}")
    Shop addOne(@RequestBody Shop shop_local,
                @PathVariable("name") String username){
        User user = stus.getUser(username)
        shop_local.setUser(user)
        repo.save(shop_local)
    }

    @DeleteMapping("{id}")
    deleteOne(@PathVariable("id") Shop shop_local){
        repo.delete(shop_local)
    }

    @PutMapping("updateUser/{id}")
    Shop updateUser(@PathVariable("id") Shop shop,
                    @RequestBody String user_name){
        User usr = stus.getUser(user_name)
        shop.setUser(usr)
        shop
    }


}
