package com.example.eComm.Customer.Controller;

import com.example.eComm.Customer.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    //For customer
    @RequestMapping(value = "/addCustomer/{Cid}/{Cname}", method = RequestMethod.POST)
    public String createCustomer(@PathVariable int Cid, @PathVariable String Cname) {
        return customerService.createCustomer(Cid,Cname);
    }
    @RequestMapping(value = "/readAllCustomers" , method = RequestMethod.GET)
    public List<String> readAllCustomers() {
        return customerService.readAllCustomers();
    }


    @RequestMapping(value = "/findCustomerById/{id}" , method = RequestMethod.GET)
    public String findCustomerById(@PathVariable int id) {
        return customerService.findCustomerById(id);
    }

    @RequestMapping(value = "/findCustomerOrderById/{id}" , method = RequestMethod.GET)
    public List<String> findCustomerOrderById(@PathVariable int id) {
        return customerService.findCustomerOrderById(id);
    }

    @RequestMapping(value = "/deleteCustomerById/{id}", method = RequestMethod.DELETE)
    public int deleteCustomerById(@PathVariable int id) {
        return customerService.deleteCustomerById(id);
    }


}
