package com.example.eComm.CategoryAndProduct.Bean;

import com.example.eComm.CategoryAndProduct.Bean.Product;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Cid;

    @Column(nullable=false, length=100)
    private String Cname;

    @OneToMany(
            mappedBy="category",
            cascade = CascadeType.ALL,
            fetch =  FetchType.LAZY)
            private  Set<Product> product;


    public Category(){
        product = new HashSet<>();
    }

    public Category(String cname)
    {
        this.Cname = cname;
        product = new HashSet<>();
    }

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
        this.Cname = cname;
    }

    public Set<Product> getProduct()
    {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
        for(Product prod : product){
            prod.setCategory(this);
        }
    }


}
