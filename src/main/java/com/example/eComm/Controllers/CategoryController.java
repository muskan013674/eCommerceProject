package com.example.eComm.Controllers;

import com.example.eComm.Projection.CategoryProjection;
import com.example.eComm.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

        @Autowired
        private CategoryService categoryService;

        @PostMapping(value = "/")
        public String create(@RequestBody(required = true) CategoryProjection categoryProjection) {
            return categoryService.create(categoryProjection.getCid(),categoryProjection.getCname(), categoryProjection.getName(), categoryProjection.getRate());
        }

        @GetMapping(value = "readAll/Categories")
        public List<String> readAllCategories() {
            return categoryService.readAll();
        }

        @GetMapping(value = "/searchByCategory/{id}" )
        public String searchByCategoryId(@PathVariable int id) {
            return categoryService.searchByCategoryId(id);
        }

        @DeleteMapping(value = "/deleteBy/Category/{id}")
        public int  deleteByCategoryId(@PathVariable int id) {
            return categoryService.deleteByCategoryId(id);
        }

        @GetMapping(value = "/searchBy/Category/{name}")
        public List<String> searchByCategoryName(@PathVariable String name) {
            return categoryService.searchByCategoryName(name);
        }

    }

