package com.example.eComm.OrderDet.Bean;

import com.example.eComm.Customer.Bean.Customer;
import com.example.eComm.CategoryAndProduct.Bean.Product;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "OrderDet")
@Table(name = "Orderdet",schema = "ecomm")
public class OrderDet {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Oid;

    //Pid Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Pid" , referencedColumnName = "Pid")
    private Product product;

    //for Customer
    // Cid foreign key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cid" , referencedColumnName = "Cid")
    private Customer customer;


    private LocalDate Odate;
    private LocalDate Odel_date;
    double  Quantity;

    public int getOid() {
        return Oid;
    }

    public OrderDet(){}

    public Product getProduct() {
        return product;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        customer.getOrderDet().add(this);
    }

    public void setProduct(Product product) {
        this.product = product;
        product.getOrderDet().add(this);
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }
    public LocalDate getOdate() {
        return Odate;
    }

    public void setOdate(LocalDate odate) {
        Odate = odate;
    }

    public LocalDate getOdel_date() {
        return Odel_date;
    }

    public void setOdel_date(LocalDate odel_date) {
        Odel_date = odel_date;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }


    public OrderDet(Product product,LocalDate odate, LocalDate odel_date, double quantity, Customer customer) {
        this.product = product;
        //this.Pid = pid;
        this.Odate = odate;
        this.Odel_date = odel_date;
        this.Quantity = quantity;
        this.customer = customer;
    }
}

