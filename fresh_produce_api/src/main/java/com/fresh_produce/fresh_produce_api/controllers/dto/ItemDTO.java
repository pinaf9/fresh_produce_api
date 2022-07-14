package com.fresh_produce.fresh_produce_api.controllers.dto;

public class ItemDTO {
    private String name;
    private Integer quantity;
    private String imageUrl;
    private Double price;

    public ItemDTO() {
    }

    public ItemDTO(String name, Integer quantity, String imageUrl, Double price) {
        this.name = name;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
