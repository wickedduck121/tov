package test.TovAppTest.entities

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ForeignKey
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table
class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id

    String name

    float lat

    float lng

    @ManyToOne(fetch = FetchType.EAGER)
    User user

}
