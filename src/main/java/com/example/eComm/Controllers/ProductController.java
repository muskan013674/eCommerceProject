package com.example.eComm.Controllers;

import com.example.eComm.Projection.CategoryProjection;
import com.example.eComm.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping( value = "/readAll/Products")
    public List<String> readAll() {
        return productService.readAll();
    }

    @GetMapping(value = "/searchBy/Product/{id}" )
    public String searchByProductId(@PathVariable int id) {
        return productService.searchByProductId(id);
    }

    @DeleteMapping(value = "/deleteBy/Product/{id}")
    public int  deleteByProductId(@PathVariable int id) {
        return productService.deleteByProductId(id);
    }

    @GetMapping(value = "/searchBy/Product/{name}")
    public List<String>  searchByProductName(@PathVariable String name) {
        return productService.searchByProductName(name);
    }

    @GetMapping(value = "/listProductsBy/Category/{id}")
    public List<String> listProductsByCategoryId(@PathVariable int id) {
        return productService.listProductsByCategoryId(id);
    }

    @GetMapping(value = "/filterProductBy/Range/{low}/{high}")
    public List<String>  filterProductByRate(@PathVariable double low,@PathVariable double high) {
        return productService.filterProductByRate(low, high);
    }

}
