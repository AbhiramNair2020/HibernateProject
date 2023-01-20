import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddress() {
        return addresses;
    }

    public void setAddress(List<Address> address) {
        this.addresses = address;
    }

    public Person(Integer id, String name, List<Address> address) {
        this.id = id;
        this.name = name;
        this.addresses = address;
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    }

    public String toString(){
        String str = "ID: " + id + " Name: " + name;
        for (Address address : addresses){
            str = str + " " + address.getName();
        }
        return str;
    }

    @Id
    private Integer id;
    private String name;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
//    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "per_id")
    private List<Address> addresses;

}
