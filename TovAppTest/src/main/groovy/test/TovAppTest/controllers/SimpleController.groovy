package test.TovAppTest.controllers

import com.fasterxml.jackson.databind.util.BeanUtil
import groovy.transform.CompileStatic
import org.springframework.beans.BeanUtils
import org.springframework.boot.jackson.JsonObjectDeserializer
import org.springframework.web.bind.annotation.PutMapping
import test.TovAppTest.entities.Product
import test.TovAppTest.rep.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductController {

    private final ProductRepository repo;

    @Autowired
    public ProductController(ProductRepository rp){
        repo=rp;
    }

    @GetMapping
    public List<Product> list(){
        repo.findAll()
    }

    @GetMapping("{id}")
    public Product getOne(@PathVariable("id") Product element)
    {
        element
    }

    @PutMapping("{id}")
    public Product update(
            @PathVariable("id") Product elementDB,
            @RequestBody Product element
    ){
        //repo.setProductById(element.name,element.price,element.id);
        elementDB.name=element.name
        elementDB.price=element.price
      //  elementDB.id=element.id
        repo.save(elementDB)
        def row = repo.getOne(element.id)
        //BeanUtils.copyProperties(element,elementDB, 'id');
        row
    }

    @PostMapping
    public Product add(@RequestBody Product element){
        repo.save(element)
    }

    @DeleteMapping("{id}")
    public void del(@PathVariable("id") Product element){
        repo.delete(element)
    }
}

