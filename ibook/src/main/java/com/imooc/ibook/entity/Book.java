package com.imooc.ibook.entity;

import java.sql.Timestamp;

public class Book {
    private int id;
    private int categoryId;
    private String name;
    private int level;
    private int price;
    private String imgPath;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Category category=new Category();

    public Book(){

    }

    public Book(int id, int categoryId, String name, int level, int price, String imgPath, Timestamp createTime, Timestamp updateTime, Category category) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.level = level;
        this.price = price;
        this.imgPath = imgPath;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", price=" + price +
                ", imgPath='" + imgPath + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", category=" + category +
                '}';
    }
}
