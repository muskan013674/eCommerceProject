package com.example.eComm.Repositories;

import com.example.eComm.Beans.OrderDet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderDetRepository extends JpaRepository<OrderDet,Integer> {

    @Query("SELECT O FROM  OrderDet O where  O.Oid = ?1")
    public List<OrderDet> findOrderDetById(int id);

    @Query("SELECT P FROM  OrderDet P where P.Oid = ?1")
    public OrderDet findOrderById(int Oid);


    @Modifying
    @Transactional
    @Query("DELETE FROM OrderDet o WHERE o.Oid = ?1")
    int deleteByOrderDetId(int id);

}