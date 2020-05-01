package com.imooc.hos.controller;

import com.imooc.hos.entity.Category;
import com.imooc.hos.entity.Dept;
import com.imooc.hos.service.CategoryService;
import com.imooc.hos.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("frontController")
public class FrontController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DeptService deptService;

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList=categoryService.getAll();
        request.setAttribute("CLIST",categoryList);
        Map<Integer,List<Dept>>map=new HashMap<>();
        for (Category category:categoryList){
            map.put(category.getId(),deptService.findAllByCid(category.getId()));
        }
        request.setAttribute("MAP",map);
        request.getRequestDispatcher("../hospital_index.jsp").forward(request,response);

    }

}
