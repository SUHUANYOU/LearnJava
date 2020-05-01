package com.imooc.hos.dao;

import com.imooc.hos.entity.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("deptDao")
public interface DeptDao {
    void insertDept(Dept dept);
    void updateDept(Dept dept);
    void deleteDept(Integer id);
    Dept findById(Integer id);

    List<Dept> findAll();

    List<Dept> findAllByCid(Integer id);

}
