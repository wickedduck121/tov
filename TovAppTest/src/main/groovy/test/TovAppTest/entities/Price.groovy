package test.TovAppTest.entities

import javax.persistence.*

@Entity
@Table(name="price")
class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id

    BigDecimal price

    @ManyToOne(fetch = FetchType.EAGER)
    Shop shop

    @ManyToOne(fetch = FetchType.EAGER)
    Product product
}
