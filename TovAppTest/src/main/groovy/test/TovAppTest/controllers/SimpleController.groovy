package test.TovAppTest.controllers

import com.fasterxml.jackson.databind.util.BeanUtil
import groovy.transform.CompileStatic
import org.springframework.web.bind.annotation.PutMapping
import test.TovAppTest.entities.Product
import test.TovAppTest.entities.SimpleEntity
import test.TovAppTest.rep.SimpleRepos
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("message")
class SimpleController {

    private final SimpleRepos repo;

    @Autowired
    public SimpleController(SimpleRepos rp){
        repo=rp;
    }

    @GetMapping
    public List<SimpleEntity> list(){
        repo.findAll()
    }

    @GetMapping("{id}")
    public SimpleEntity getOne(@PathVariable("id") SimpleEntity element)
    {
        element
    }

    @PutMapping("{id}")
    public SimpleEntity update(
            @PathVariable("id") SimpleEntity elementDB,
            @RequestBody SimpleEntity element
    ){
        BeanUtils.copyProperties(element,elementDB, "id");
        elementDB
    }

    @PostMapping
    public SimpleEntity add(@RequestBody SimpleEntity element){
        repo.save(element)
    }

    @DeleteMapping("{id}")
    public void del(@PathVariable("id") SimpleEntity element){
        repo.delete(element)
    }
}

