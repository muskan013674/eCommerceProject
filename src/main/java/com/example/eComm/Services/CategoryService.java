package com.example.eComm.Services;

import com.example.eComm.Beans.Category;
import com.example.eComm.Beans.Product;
import com.example.eComm.Exceptions.ObjectNotFoundException;
import com.example.eComm.Repositories.CategoryRepository;
import com.example.eComm.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    public String create(int Cid, String Cname, String name, double rate) {
        List<Category> categories = new ArrayList<>();
        Category cat1 = categoryRepository.findById(Cid);
        Optional<Category> cat = Optional.ofNullable(cat1);
        if (cat.isPresent()) {
            Product product = new Product(name, rate);
            product.setCategory(cat1);
            categories.add(cat1);
            categoryRepository.saveAll(categories);
            return "Product: " + name + " added to Category: " + Cname;
        } else {
            Category category = new Category(Cname);
            Product product = new Product(name, rate);
            product.setCategory(category);
            categories.add(category);
            List<Category> list = categoryRepository.saveAll(categories);

            return "Product: " + name + " added to Category: " + Cname;
        }
    }

    public List<String> readAll() {
        List<Category> category = categoryRepository.findAll();
        if(category.isEmpty())
        {
            throw new ObjectNotFoundException("No Category Found");
        }
        List<String> list = new ArrayList<String>();
        for (Category cat : category) {
            list.add(  "Category Id : " + cat.getCid() + " " +
                    "Category Name : " + cat.getCname() );
        }
        return list;
    }

    public String  searchByCategoryId(int id) {

        Category cat =  categoryRepository.searchByCategoryId(id);
        if(Objects.isNull(cat))
        {
            throw new ObjectNotFoundException("id-"+id + " Not Found");
        }
        return  "Category Id : " + cat.getCid() + " " +
                "Category Name : " + cat.getCname();
    }
    public int deleteByCategoryId(int id) {
        int t =  categoryRepository.deleteByCategoryId(id);
        if(t == 0)
        {
            throw new ObjectNotFoundException("id-"+id + " Not Found");
        }
        return t;
    }

    public List<String> searchByCategoryName(String s) {
        List<String> list = categoryRepository.searchByCategoryName(s);
        if(list.isEmpty())
        {
            throw new ObjectNotFoundException("Category Name-"+s+ " Not Found");
        }
        return list;
    }
}
