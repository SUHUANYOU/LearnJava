package com.imooc.ibook.biz.impl;

import com.imooc.ibook.biz.BookBiz;
import com.imooc.ibook.dao.BookDao;
import com.imooc.ibook.entity.Book;
import com.imooc.ibook.global.DaoFactory;
import com.sun.org.apache.xerces.internal.impl.dv.xs.BooleanDV;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookBizImpl implements BookBiz {
    public List<Book> selectBookByCid(int categoryId) {
        BookDao dao= DaoFactory.getInstance().getDao(BookDao.class,true);
        return dao.selectBookByCid(categoryId);
    }

    public int batchBook(List<Book> books) {
        SqlSession sqlSession = null;
        int num = 0;
        try {
            sqlSession = DaoFactory.getInstance().openSession(false);
            BookDao bookDao = sqlSession.getMapper(BookDao.class);
            num = bookDao.batchBook(books);
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

    public List<Book> selectAll() {
        BookDao dao=DaoFactory.getInstance().getDao(BookDao.class,true);
        return dao.selectAll();
    }
}
