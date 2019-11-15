package test.TovAppTest.rep

import org.springframework.data.jpa.repository.JpaRepository
import test.TovAppTest.entities.Shop
import test.TovAppTest.entities.User

interface ShopRepository extends JpaRepository<Shop, Long> {
    Shop findByName(String name)
    List<Shop> findByUser(User user)



}
