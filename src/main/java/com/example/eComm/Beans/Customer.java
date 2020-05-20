package com.example.eComm.Beans;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Cid;

    private String Cname;

    //Oid Foreign Key
    @OneToMany(
            mappedBy="customer",
            cascade = CascadeType.ALL,
            fetch =  FetchType.LAZY)
    private Set<OrderDet> orderDet;

    public Customer(String cname, Set<OrderDet> orderDet) {
        Cname = cname;
        this.orderDet = orderDet;
    }

    public Customer(){}
    public int getCid() {
        return Cid;
    }

    public void setCid(int cid) {
        Cid = cid;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public Set<OrderDet> getOrderDet() {
        return orderDet;
    }

    public void setOrderDet(Set<OrderDet> orderDet) {
        this.orderDet = orderDet;
        for(OrderDet orderDet1 : orderDet){
            orderDet1.setCustomer(this);
        }
    }
}
