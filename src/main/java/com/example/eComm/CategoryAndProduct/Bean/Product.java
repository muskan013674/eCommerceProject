package com.example.eComm.CategoryAndProduct.Bean;

import com.example.eComm.OrderDet.Bean.OrderDet;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Pid;

    @Column(name = "Name" , nullable=false, length=100)
    private String Name;
    private double Rate;

// Cid foreign key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cid" , referencedColumnName = "Cid")
    private Category category;

    //For Order Det
    @OneToMany(
            mappedBy="product",
            cascade = CascadeType.ALL,
            fetch =  FetchType.LAZY)
    private Set<OrderDet> orderDet;

    public Product(){
        //For orderDet
        orderDet = new HashSet<>();
    }

    public int getPid() {
        return Pid;
    }

    public void setPid(int pid) {
        Pid = pid;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double rate) {
        Rate = rate;
    }

    public Product(String name, double rate) {
        this.Name = name;
        this.Rate = rate;
        //For orderDet
        orderDet = new HashSet<>();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        category.getProduct().add(this);
    }

    //For orderDet
    public Set<OrderDet> getOrderDet()
    {
        return orderDet;
    }
    //For orderDet
    public void setOrderDet(Set<OrderDet> orderDet) {
        this.orderDet = orderDet;
        for(OrderDet orderDet1 : orderDet){
            orderDet1.setProduct(this);
        }
    }



}
