package code.TovApp.entities

import lombok.Data
import lombok.ToString

import javax.persistence.*

@Entity
@Table(name = "tov")
class SimpleEntity {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long ID
    private String name;
    private float price;
    SimpleEntity(long ID, String name, float price){
        this.ID=ID;
        this.name=name;
        this.price=price;
    }
    @Override
    public String toString(){
        String.format("product: id=%d, name=%s, price=%f",ID, name, price)
    }

    public Long getID(){
        ID
    }
    public String getname(){
        name
    }
    public getprice(){
        price
    }
}
