package com.example.eComm.CategoryAndProduct.Service;

import com.example.eComm.CategoryAndProduct.Bean.Category;
import com.example.eComm.CategoryAndProduct.Bean.Product;
import com.example.eComm.CategoryAndProduct.Repository.CategoryRepository;
import com.example.eComm.Exceptions.ObjectNotFoundException;
import com.example.eComm.CategoryAndProduct.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductService(CategoryRepository categoryRepository,
                          ProductRepository productRepository)
    {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public String create(int Cid, String Cname, String name, double rate) {
        List<Category> categories = new ArrayList<>();
        Category cat1 = categoryRepository.findById(Cid);
        Optional<Category> cat = Optional.ofNullable(cat1);
        if(cat.isPresent())
        {
            Product product = new Product(name, rate);
            product.setCategory(cat1);
            categories.add(cat1);
            categoryRepository.saveAll(categories);
            return "Product: " + name + " added to Category: " + Cname;
        }
        else {
            Category category = new Category(Cname);
            Product product = new Product(name, rate);
            product.setCategory(category);
            categories.add(category);
           List<Category>  list=  categoryRepository.saveAll(categories);

            return "Product: " + name + " added to Category: " + Cname;
        }
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
    public String  searchByCategoryId(int id) {

        Category cat =  productRepository.searchByCategoryId(id);
        if(Objects.isNull(cat))
        {
            throw new ObjectNotFoundException("id-"+id + " Not Found");
        }
        return  "Category Id : " + cat.getCid() + " " +
                "Category Name : " + cat.getCname();
    }

    public int deleteByProductId(int id) {
        int t = productRepository.deleteByProductId(id);
        if(t == 0)
        {
            throw new ObjectNotFoundException("id-"+id + " Not Found");
        }
        return t;
    }

    public int deleteByCategoryId(int id) {
        int t =  productRepository.deleteByCategoryId(id);
        if(t == 0)
        {
            throw new ObjectNotFoundException("id-"+id + " Not Found");
        }
        return t;
    }

    public List<String> searchByCategoryName(String s) {
        List<String> list = productRepository.searchByCategoryName(s);
        if(list.isEmpty())
        {
            throw new ObjectNotFoundException("Category Name-"+s+ " Not Found");
        }
        return list;
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