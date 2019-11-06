package code.TovApp.rep

import code.TovApp.entities.SimpleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SimpleRepos extends JpaRepository<SimpleEntity, Long>{

}