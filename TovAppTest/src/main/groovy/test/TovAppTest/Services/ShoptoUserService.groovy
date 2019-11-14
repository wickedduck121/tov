package test.TovAppTest.Services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import test.TovAppTest.entities.Shop
import test.TovAppTest.entities.User
import test.TovAppTest.rep.ShopRepository
import test.TovAppTest.rep.UserRepository

@Service
class ShoptoUserService {
    @Autowired
    ShopRepository repo1
    @Autowired
    UserRepository repo2


    User getUser(name_user) {
        repo2.findByName(name_user)
    }

    Shop getShop(String shop_name){
        repo1.findByName(shop_name)
    }

    Shop createShop(name_shop, name_user){

     User user = repo2.findByName(name_user)

        Shop shop_buf = new Shop()
        shop_buf.setUser(user)
        shop_buf.setName(name_shop)
        shop_buf
    }

}
