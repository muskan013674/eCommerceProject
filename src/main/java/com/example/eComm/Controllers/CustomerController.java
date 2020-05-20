package com.example.eComm.Controllers;

import com.example.eComm.Projection.CustomerProjection;
import com.example.eComm.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    //For customer

    @GetMapping(value = "/readAll/Customers")
    public List<String> readAllCustomers() {
        return customerService.readAllCustomers();
    }

    @PostMapping(value = "/add/Customer")
    public String createCustomer(@RequestBody(required = true)CustomerProjection customerProjection) {
        return customerService.createCustomer(customerProjection.getCid(),customerProjection.getCname());
    }

    @GetMapping(value = "/findBy/Customer/{id}" )
    public String findCustomerById(@PathVariable int id) {
        return customerService.findCustomerById(id);
    }

    @GetMapping(value = "/findBy/CustomerOrder/{id}" )
    public List<String> findCustomerOrderById(@PathVariable int id) {
        return customerService.findCustomerOrderById(id);
    }

    @DeleteMapping(value = "/deleteBy/Customer/{id}")
    public int deleteCustomerById(@PathVariable int id) {
        return customerService.deleteCustomerById(id);
    }


}
