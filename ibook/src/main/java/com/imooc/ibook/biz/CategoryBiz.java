package com.imooc.ibook.biz;

import com.imooc.ibook.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryBiz {
    List<Category> selectAll();

    /**
     * 根据某个ID查询分类
     */
    Category selectById(@Param("id") int id);

    int addCategory(Category category);

    int delete(@Param("id") int id);
}
