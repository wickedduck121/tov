package test.TovAppTest.rep

import org.springframework.data.jpa.repository.JpaRepository
import test.TovAppTest.entities.Shop

interface ShopRepository extends JpaRepository<Shop, Long> {
Shop findByName(String name)

}