package com.sept.Yufan_Jiang.rest.model;

public class Item {
    public Item(){
    }
    private String id;
    private String name;
    private String desc;
    private double price;
    private String imagePath;
    public Item(String id, String name, String desc, double price,String imagePath) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.imagePath = imagePath ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

}
