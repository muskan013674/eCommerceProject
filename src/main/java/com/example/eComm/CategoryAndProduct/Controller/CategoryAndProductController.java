package com.example.eComm.CategoryAndProduct.Controller;

import com.example.eComm.CategoryAndProduct.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryAndProductController {
    @Autowired
    private ProductService productService;


    //For Product and Category
    @RequestMapping(value = "/addCategory/{Cid}/{Cname}/{Name}/{Rate}", method = RequestMethod.POST)
    public String create(@PathVariable int Cid, @PathVariable String Cname, @PathVariable String Name, @PathVariable Double Rate) {
        return productService.create(Cid,Cname, Name, Rate);
    }

    @RequestMapping(value = "/readAllProducts" , method = RequestMethod.GET)
    public List<String> readAll() {
        return productService.readAll();
    }

    @RequestMapping(value = "/searchByProductId/{id}" , method = RequestMethod.GET)
    public String searchByProductId(@PathVariable int id) {
        return productService.searchByProductId(id);
    }

    @RequestMapping(value = "/searchByCategoryId/{id}" , method = RequestMethod.GET)
    public String searchByCategoryId(@PathVariable int id) {
        return productService.searchByCategoryId(id);
    }

    @RequestMapping(value = "/deleteByProductId/{id}", method = RequestMethod.DELETE)
    public int  deleteByProductId(@PathVariable int id) {
        return productService.deleteByProductId(id);
    }

    @RequestMapping(value = "/deleteByCategoryId/{id}", method = RequestMethod.DELETE)
    public int  deleteByCategoryId(@PathVariable int id) {
        return productService.deleteByCategoryId(id);
    }

    @RequestMapping(value = "/searchByCategoryName/{s}", method = RequestMethod.GET)
    public List<String> searchByCategoryName(@PathVariable String s) {
        return productService.searchByCategoryName(s);
    }

    @RequestMapping(value = "/searchByProductName/{s}", method = RequestMethod.GET)
    public List<String>  searchByProductName(@PathVariable String s) {
        return productService.searchByProductName(s);
    }

    @RequestMapping(value = "/listProductsByCategoryId/{id}", method = RequestMethod.GET)
    public List<String> listProductsByCategoryId(@PathVariable int id) {
        return productService.listProductsByCategoryId(id);
    }

    @RequestMapping(value = "/filterProductByRange/{low}/{high}", method = RequestMethod.GET)
    public List<String>  filterProductByRate(@PathVariable double low,@PathVariable double high) {
        return productService.filterProductByRate(low, high);
    }


}
