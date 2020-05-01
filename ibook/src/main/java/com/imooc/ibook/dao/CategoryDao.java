package com.imooc.ibook.dao;

import com.imooc.ibook.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CategoryDao {
    /**
     * 查询所有分类
     */
    @Select("select * from category")
    List<Category> selectAll();
    /**
     * 根据某个ID查询分类
     * id
     */
    @Select("select * from category where id = #{id}")
    Category selectById(@Param("id") int id);

    @Insert("insert into category(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    int addCategory(Category category);

    @Delete("delete from category where id = #{id}")
    int delete(@Param("id") int id);

}
