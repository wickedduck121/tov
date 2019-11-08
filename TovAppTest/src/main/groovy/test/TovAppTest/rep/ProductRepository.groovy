package test.TovAppTest.rep

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import test.TovAppTest.entities.Product

interface ProductRepository extends JpaRepository<Product, Long>{
    @Modifying
    @Query("update Product p set p.name = ?1, p.price = ?2 where p.id = ?3")
    void setProductById(String name, BigDecimal price, Long id);
}