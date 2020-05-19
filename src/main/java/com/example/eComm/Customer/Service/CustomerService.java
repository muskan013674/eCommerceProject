package com.example.eComm.Customer.Service;

import com.example.eComm.Customer.Bean.Customer;
import com.example.eComm.Customer.Repository.CustomerRepository;
import com.example.eComm.Exceptions.ObjectNotFoundException;
import com.example.eComm.OrderDet.Bean.OrderDet;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String createCustomer(int Cid, String Cname) {
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = customerRepository.findById(Cid);

        Optional<Customer> cus = Optional.ofNullable(customer1);
        if(!cus.isPresent())
        {
            Set<OrderDet> orderDet = new HashSet<OrderDet>();
            Customer customer = new Customer(Cname,orderDet);
            customer.setOrderDet(orderDet);
            customers.add(customer);
             customerRepository.saveAll(customers);
             return "Customer: " + Cname + " created" ;
        }
        else
            return "Customer not created";
    }

    public List<String> readAllCustomers() {
        List<Customer> customer = customerRepository.findAll();
        if(customer.isEmpty())
        {
            throw new ObjectNotFoundException("No Customer Found");
        }
        List<String> list = new ArrayList<String>();
        for (Customer cus : customer) {
            list.add(  "Customer Id : " + cus.getCid() + " " +
                    "Customer Name : " + cus.getCname() );

        }
        return list;
    }
    public String findCustomerById(int id) {

        String cus = customerRepository.findCustomerById(id);
        if(cus.equals(" ") || Objects.isNull(cus))
        {
            throw new ObjectNotFoundException("id-"+id + " Not Found");
        }
        return  cus;
    }

    public List<String> findCustomerOrderById(int id) {
        List<String> list = customerRepository.findCustomerOrderById(id);
        if(list.isEmpty())
        {
            throw new ObjectNotFoundException("id-"+id + " Not Found");

        }
        return list;
    }

    public int deleteCustomerById(int id) {
        int t = customerRepository.deleteCustomerById(id);
        if(t == 0)
        {
            throw new ObjectNotFoundException("id-"+id + " Not Found");

        }
        return t;
    }
}
