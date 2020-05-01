package com.imooc.hos.service;

import com.imooc.hos.entity.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);
    void remove(Integer id);
    void edit(Category category);
    Category get(Integer id);
    List<Category> getAll();
}
