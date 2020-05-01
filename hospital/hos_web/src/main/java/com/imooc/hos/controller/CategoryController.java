package com.imooc.hos.controller;

import com.imooc.hos.entity.Category;
import com.imooc.hos.service.CategoryService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("categoryController")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    // /category/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list=categoryService.getAll();
        request.setAttribute("CLIST",list);
        request.getRequestDispatcher("../category_list.jsp").forward(request,response);
    }

    public void toAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../category_add.jsp").forward(request,response);
    }
    public void add(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String name=request.getParameter("name");
        Category category=new Category();
        category.setName(name);
        categoryService.add(category);
        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        Category category=categoryService.get(id);
        request.setAttribute("OBJ",category);
        request.getRequestDispatcher("../category_edit.jsp").forward(request,response);
    }
    public void edit(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        Category category=categoryService.get(id);
        category.setName(name);
        categoryService.edit(category);
        response.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        categoryService.remove(id);
        response.sendRedirect("list.do");
    }

}
