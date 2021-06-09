package dev.nnhao.dto;


public class Product {
    private String name;
    private String cost;
//    private String imageUrl;
    private int imageId;

    public Product(String name, String cost, int imageId) {
        this.name = name;
        this.cost = cost;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
//    public Product(String name, String cost, String imageUrl) {
//        this.name = name;
//        this.cost = cost;
//        this.imageUrl = imageUrl;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "name='" + name + '\'' +
//                ", cost='" + cost + '\'' +
//                ", imageUrl='" + imageUrl + '\'' +
//                '}';
//    }
}