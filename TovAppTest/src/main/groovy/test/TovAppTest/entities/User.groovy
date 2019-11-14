package test.TovAppTest.entities

import groovy.transform.ToString

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
@ToString(includeNames = true)
@Table(name='users')

class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id

    @NotNull
    @NotEmpty
    String name

    @NotNull
    @NotEmpty
    String pass

    @NotNull
    @NotEmpty
    String email

    @NotNull
    @NotEmpty
    String gender

    @OneToMany(mappedBy = 'user', cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Shop> shops;

}
