package test.TovAppTest.Services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import test.TovAppTest.entities.Product
import test.TovAppTest.entities.Shop
import test.TovAppTest.entities.User
import test.TovAppTest.rep.PriceRepository
import test.TovAppTest.rep.ProductRepository
import test.TovAppTest.rep.ShopRepository
import test.TovAppTest.rep.UserRepository

@Service
class RepositoryService {
    @Autowired
    ShopRepository repo_shop
    @Autowired
    UserRepository repo_user
    @Autowired
    ProductRepository repo_prod


    User getUser(String name_user) {
        repo_user.findByName(name_user)
    }

    Shop getShop(String shop_name){
        repo_shop.findByName(shop_name)
    }

    Product getProduct(String product_name){
        repo_prod.findByName(product_name)
    }


}
