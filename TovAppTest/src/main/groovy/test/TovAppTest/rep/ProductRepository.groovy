package test.TovAppTest.rep

import org.springframework.data.jpa.repository.JpaRepository
import test.TovAppTest.entities.Product

interface ProductRepository extends JpaRepository<Product, Long>{

}