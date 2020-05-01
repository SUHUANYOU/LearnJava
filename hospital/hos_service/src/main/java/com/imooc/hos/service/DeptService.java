package com.imooc.hos.service;

import com.imooc.hos.entity.Dept;

import java.util.List;

public interface DeptService {
    void insertDept(Dept dept);
    void updateDept(Dept dept);
    void deleteDept(Integer id);
    Dept findById(Integer id);
    List<Dept> findAll();
    List<Dept> findAllByCid(Integer cid);
}
