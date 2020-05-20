package com.example.eComm.Repositories;

import com.example.eComm.Beans.Category;
import com.example.eComm.Beans.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("SELECT P FROM  Product P  where  P.Pid = ?1")
    public Product searchByProductId(int id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Product  WHERE Pid = ?1")
    int deleteByProductId(int id);

    @Query(" select P.Pid, P.Name, P.Rate, C.Cname FROM Product P inner join Category C ON P.category.Cid = C.Cid WHERE P.Name like %:string% ")
    List<String> searchByProductName( @Param("string") String s);

    @Query("SELECT P.Pid, P.Name, P.Rate FROM  Product P inner join Category  C on P.category.Cid = C.Cid where  C.Cid = ?1")
    public List<String> listProductsByCategoryId(int id);

    @Query(" select P.Pid, P.Name, P.Rate, C.Cname FROM Product P inner join Category C ON P.category.Cid = C.Cid WHERE P.Rate between ?1 and ?2 ")
    List<String> filterProductByRate( @Param("string") double l, double h);

    @Query("SELECT P FROM  Product P where P.Pid = ?1")
    public Product findProductById(int Pid);


}
