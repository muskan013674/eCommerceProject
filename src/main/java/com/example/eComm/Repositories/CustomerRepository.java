package com.example.eComm.Repositories;

import com.example.eComm.Beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT Cid, Cname FROM Customer  where Cid = ?1")
    public String findCustomerById(int Cid);

    @Query("SELECT c FROM Customer c where Cid = ?1")
    public Customer findById(int Cid);

    @Query("SELECT C.Cid, C.Cname, O.Oid, P.Pid, P.Name FROM Customer  C inner join OrderDet O on C.Cid = O.customer.Cid " +
            "inner join Product P on P.Pid = O.product.Pid where C.Cid = ?1")
    public List<String> findCustomerOrderById(int Cid);


    @Modifying
    @Transactional
    @Query("DELETE FROM Customer c WHERE c.Cid = ?1")
    public int deleteCustomerById(int id);
}
