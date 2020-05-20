package com.example.eComm.Services;

import com.example.eComm.Beans.Category;
import com.example.eComm.Beans.Product;
import com.example.eComm.Repositories.CategoryRepository;
import com.example.eComm.Exceptions.ObjectNotFoundException;
import com.example.eComm.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService( ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public List<String> readAll() {
        List<Product> products = productRepository.findAll();
        if(products.isEmpty())
        {
            throw new ObjectNotFoundException("No Product Found");
        }
        List<String> list = new ArrayList<String>();
        for (Product prod : products) {
            list.add(  "Product Id : " + prod.getPid() + " " +
                       "Product Name : " + prod.getName() + " " +
                       "Category Id : " + prod.getCategory().getCid()+ " " +
                       "Category Name : " + prod.getCategory().getCname()+ " " +
                       "Product Rate : " + prod.getRate());
        }
        return list;
    }

    public String searchByProductId(int id) {
       Product prod =  productRepository.searchByProductId(id);

        if(Objects.isNull(prod))
        {
            throw new ObjectNotFoundException("id-"+id + " Not Found");
        }
        return  "Product Id : " + prod.getPid() + " " +
                "Product Name : " + prod.getName() + " " +
                "Category Id : " + prod.getCategory().getCid()+ " " +
                "Category Name : " + prod.getCategory().getCname()+ " " +
                "Product Rate : " + prod.getRate();
    }

    public int deleteByProductId(int id) {
        int t = productRepository.deleteByProductId(id);
        if(t == 0)
        {
            throw new ObjectNotFoundException("id-"+id + " Not Found");
        }
        return t;
    }


    public List<String> searchByProductName(String s) {

        List<String> list = productRepository.searchByProductName(s);
        if(list.isEmpty())
        {
            throw new ObjectNotFoundException("Product Name-"+s + " Not Found");
        }
        return list;
    }

    public List<String> listProductsByCategoryId(int id) {
        List<String> products = productRepository.listProductsByCategoryId(id);
        if(products.isEmpty())
        {
            throw new ObjectNotFoundException("id-"+id+ " Not Found");
        }
        return products;
    }

    public List<String> filterProductByRate(double low, double high) {
        List<String> list = productRepository.filterProductByRate(low, high);
        if(list.isEmpty())
        {
            throw new ObjectNotFoundException("Product range-"+ low + "-" + high + " Not Found");
        }
        return list;
    }


}