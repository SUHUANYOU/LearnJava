package com.imooc.ibook.global;

import com.imooc.ibook.biz.CategoryBiz;
import com.imooc.ibook.biz.impl.CategoryBizImpl;
import com.imooc.ibook.entity.Category;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

public class InitListener implements ServletContextListener {
    CategoryBiz categoryBiz=new CategoryBizImpl();

    public void contextInitialized(ServletContextEvent sce) {
        List<Category> categories=categoryBiz.selectAll();
        sce.getServletContext().setAttribute("categories",categories);
    }
}
