package com.imooc.ibook.controller;

import com.imooc.ibook.biz.CategoryBiz;
import com.imooc.ibook.biz.impl.CategoryBizImpl;
import com.imooc.ibook.entity.Category;
import com.imooc.ibook.global.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class CategoryController {
    private CategoryBiz categoryBiz=new CategoryBizImpl();
    //  /admin/Category/toList.do
    public void toList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/admin/category.jsp").forward(request,response);
    }
    // /admin/Category/toAdd.do打开添加界面
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/admin/category_add.jsp").forward(request,response);

    }
    // /admin/Category/add.do进行实际的添加处理
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        String name=request.getParameter("name");
        Timestamp createTime=new Timestamp(new Date().getTime());
        Timestamp updateTime=new Timestamp(new Date().getTime());
        Category category=new Category();
        category.setName(name);
        category.setCreateTime(createTime);
        category.setUpdateTime(updateTime);
        categoryBiz.addCategory(category);
        response.sendRedirect("list.do");


    }
    // list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Category> categories=categoryBiz.selectAll();
        System.out.println("request="+categories.toString());
        request.getServletContext().setAttribute("categories",categories);
        request.getRequestDispatcher("/WEB-INF/pages/admin/category.jsp").forward(request,response);


    }
    // delete
    public void remove(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));
        categoryBiz.delete(id);
        response.sendRedirect("list.do");


    }
}
