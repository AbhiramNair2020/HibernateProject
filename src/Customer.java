import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name="WHOLESALE_CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    @SequenceGenerator(name="customer_sequence", sequenceName = "cust_seq",allocationSize = 1)
    private Long id;

//    @Column
//    @JoinColumn
//    @OneToMany
//    @ManyToOne
//    @Cascade()
    private String customerId;

    @Column(name="REPORT_DATE")
    private Date date;

    public Customer(){

    }

    public Customer(Long id, String customerId, Date date) {
        this.id = id;
        this.customerId = customerId;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Customer(String customerId, Date date) {
        this.customerId = customerId;
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
