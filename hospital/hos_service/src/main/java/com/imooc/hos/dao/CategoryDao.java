package com.imooc.hos.dao;

import com.imooc.hos.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryDao")
public interface CategoryDao {
    void insert(Category category);
    void delete(Integer id);
    void update(Category category);
    Category selectById(Integer id);
    List<Category> selectAll();

}
