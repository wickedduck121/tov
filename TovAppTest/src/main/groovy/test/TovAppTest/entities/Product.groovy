package test.TovAppTest.entities

import groovy.transform.ToString

import javax.persistence.*

@Entity
@ToString(includeNames = true)
@Table(name = 'products')
class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    String name

    BigDecimal price
}

//@Entity
//@Table(name = "tov")
//class SimpleEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long ID
//    private String name;
//    private float price;
//    public SimpleEntity(long ID, String name, float price){
//       // this.ID=ID;
//        this.name=name;
//        this.price=price;
//    }
//    public SimpleEntity(){
//        name='unknown';
//        price=0;
//    }
//    @Override
//    public String toString(){
//        String.format("product: id=%d, name=%s, price=%f",ID, name, price)
//    }
//
//    public Long getID(){
//        ID
//    }
//    public String getname(){
//        name
//    }
//    public getprice(){
//        price
//    }
//}
