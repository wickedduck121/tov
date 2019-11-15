package test.TovAppTest.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import test.TovAppTest.Services.RepositoryService
import test.TovAppTest.entities.Price
import test.TovAppTest.entities.Product
import test.TovAppTest.entities.Shop
import test.TovAppTest.rep.PriceRepository

@RestController
@RequestMapping('/prices')
class PriceController {

    private final PriceRepository repo

    @Autowired
    RepositoryService rs

    @Autowired
    PriceController(PriceRepository rp){
        repo=rp
    }

    @GetMapping
    List<Price> getAll(){
        repo.findAll()
    }

    @GetMapping('/shop/{name}')
    List<Price> getByShopName(@PathVariable('name') String name)
    {
        Shop shop = rs.getShop(name)
        repo.findByShop(shop)
    }

    @GetMapping('/product/{name}')
    List<Price> getByProductName(@PathVariable('name') String name)
    {
        Product product = rs.getProduct(name)
        repo.findByProduct(product)

    }
    @PostMapping('/{price}')
    Price addOne(@PathVariable('price') BigDecimal price_value,
                @RequestParam String product_name,
                @RequestParam String shop_name)
    {
        Product product = rs.getProduct(product_name)
        Shop shop = rs.getShop(shop_name)
        Price price = new Price()
        price.setPrice(price_value)
        price.setProduct(product)
        price.setShop(shop)

    }




}
