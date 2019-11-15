package test.TovAppTest.rep

import org.springframework.data.jpa.repository.JpaRepository
import test.TovAppTest.entities.Price
import test.TovAppTest.entities.Product
import test.TovAppTest.entities.Shop

interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findByShop(Shop shop)
    List<Price> findByProduct(Product product)

}