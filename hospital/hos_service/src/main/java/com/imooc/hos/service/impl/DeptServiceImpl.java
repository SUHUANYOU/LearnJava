package com.imooc.hos.service.impl;

import com.imooc.hos.dao.DeptDao;
import com.imooc.hos.entity.Dept;
import com.imooc.hos.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("deptService")
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    public void insertDept(Dept dept) {
        dept.setCreateTime(new Date());
        dept.setUpdateTime(new Date());
        deptDao.insertDept(dept);

    }

    public void updateDept(Dept dept) {
        dept.setUpdateTime(new Date());
        deptDao.updateDept(dept);

    }

    public void deleteDept(Integer id) {
        deptDao.deleteDept(id);

    }

    public Dept findById(Integer id) {
        return deptDao.findById(id);
    }

    public List<Dept> findAll() {
        return deptDao.findAll();
    }

    public List<Dept> findAllByCid(Integer cid) {
        return deptDao.findAllByCid(cid);
    }
}
