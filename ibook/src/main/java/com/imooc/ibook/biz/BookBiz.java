package com.imooc.ibook.biz;

import com.imooc.ibook.entity.Book;

import java.util.List;

public interface BookBiz {
    List<Book> selectBookByCid(int categoryId);

    int batchBook(List<Book> books);

    List<Book> selectAll();
}
