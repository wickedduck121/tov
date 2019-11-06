package code.TovApp.controllers

import code.TovApp.entities.SimpleEntity
import code.TovApp.rep.SimpleRepos
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
    public List<SimpleEntity> rt(){
        repo.FindAll()
    }

    @GetMapping
    public SimpleEntity getOne(@PathVariable("id") SimpleEntity element)
    {
        element
    }

    @PostMapping
    public SimpleEntity add(@RequestBody SimpleEntity element){
        repo.save(element)
    }

    @DeleteMapping
    public void del(@PathVariable("id") SimpleEntity element){
        repo.delete(element)
    }
}

