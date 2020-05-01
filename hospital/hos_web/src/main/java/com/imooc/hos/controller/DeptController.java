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
import java.util.List;

@Controller("deptController")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private CategoryService categoryService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category>categoryList=categoryService.getAll();
        Integer cid=Integer.parseInt(request.getParameter("cid"));
        Category category=categoryService.get(cid);
        List<Dept>deptList=deptService.findAllByCid(cid);
        request.setAttribute("COBJ", category);
        request.setAttribute("CLIST",categoryList);
        request.setAttribute("DLIST",deptList);
        request.getRequestDispatcher("../dept_list.jsp").forward(request,response);
    }
    public void toAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Category>categoryList=categoryService.getAll();
        request.setAttribute("CLIST",categoryList);
        request.getRequestDispatcher("../dept_add.jsp").forward(request,response);
    }
    public void add(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String name=request.getParameter("name");
        Integer cid=Integer.parseInt(request.getParameter("categoryId"));
        Dept dept=new Dept();
        dept.setCategoryId(cid);
        dept.setName(name);
        deptService.insertDept(dept);
        response.sendRedirect("list.do?cid="+cid);
    }

    public void toEdit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        Dept dept=deptService.findById(id);
        request.setAttribute("OBJ",dept);
        List<Category> categoryList=categoryService.getAll();
        request.setAttribute("CLIST",categoryList);
        request.getRequestDispatcher("../dept_edit.jsp").forward(request,response);

    }
    public void edit(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        Integer categoryId=Integer.getInteger(request.getParameter("cid"));
        Dept dept=deptService.findById(id);
        dept.setName(name);
        dept.setCategoryId(categoryId);
        deptService.updateDept(dept);
        response.sendRedirect("list.do?cid="+categoryId);
    }
    public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        Integer cid=Integer.parseInt(request.getParameter("cid"));
        deptService.deleteDept(id);
        response.sendRedirect("list.do?cid="+cid);
    }
}
