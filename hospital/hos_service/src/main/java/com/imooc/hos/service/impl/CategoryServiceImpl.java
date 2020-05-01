package com.imooc.hos.service.impl;

import com.imooc.hos.dao.CategoryDao;
import com.imooc.hos.entity.Category;
import com.imooc.hos.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    public void add(Category category) {
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());
        categoryDao.insert(category);

    }

    public void remove(Integer id) {
        categoryDao.delete(id);

    }

    public void edit(Category category) {
        category.setUpdateTime(new Date());
        categoryDao.update(category);

    }

    public Category get(Integer id) {
        return categoryDao.selectById(id);
    }

    public List<Category> getAll() {
        return categoryDao.selectAll();
    }
}
