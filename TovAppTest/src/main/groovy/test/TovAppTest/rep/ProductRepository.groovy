package test.TovAppTest.rep

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import test.TovAppTest.entities.Product

interface ProductRepository extends JpaRepository<Product, Long>{
    Product findByName(String name)
}