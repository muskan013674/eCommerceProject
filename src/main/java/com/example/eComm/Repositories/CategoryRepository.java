package com.example.eComm.Repositories;

import com.example.eComm.Beans.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    @Query("SELECT C FROM  Category C where C.Cid = ?1")
    public Category findById(int id);

    @Query("SELECT C FROM  Category C  where  C.Cid = ?1")
    public Category searchByCategoryId(int id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Category c WHERE Cid = ?1")
    int deleteByCategoryId(int id);

    @Query(" select P.Pid, P.Name, P.Rate, C.Cname FROM Product P inner join Category C ON P.category.Cid = C.Cid WHERE C.Cname like %:string% ")
    List<String> searchByCategoryName( @Param("string") String s);

}
