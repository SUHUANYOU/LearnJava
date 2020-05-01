package com.imooc.ibook.biz.impl;

import com.imooc.ibook.biz.CategoryBiz;
import com.imooc.ibook.dao.CategoryDao;
import com.imooc.ibook.entity.Category;
import com.imooc.ibook.global.DaoFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryBizImpl implements CategoryBiz {

    public List<Category> selectAll() {
        CategoryDao categoryDao=DaoFactory.getInstance().getDao(CategoryDao.class,true);
        return categoryDao.selectAll();
    }

    public Category selectById(int id) {
        CategoryDao categoryDao=DaoFactory.getInstance().getDao(CategoryDao.class,true);
        return categoryDao.selectById(id);
    }

    public int addCategory(Category category) {
        SqlSession sqlSession = null;
        int num = 0;
        try {
            sqlSession = DaoFactory.getInstance().openSession(false);
            CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
            num = categoryDao.addCategory(category);
            sqlSession.commit();
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            DaoFactory.closeSession(sqlSession);
        }
        return num;
    }

    public int delete(int id) {
        SqlSession sqlSession = null;
        int num = 0;
        try {
            sqlSession = DaoFactory.getInstance().openSession(false);
            CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
            num = categoryDao.delete(id);
            sqlSession.commit();
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            DaoFactory.closeSession(sqlSession);
        }
        return num;
    }

}
