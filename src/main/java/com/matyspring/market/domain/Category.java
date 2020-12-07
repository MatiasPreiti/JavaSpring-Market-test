package com.matyspring.market.domain;

public class Category {

    private int categoryId;
    private String category;
    private boolean active;

    public int getCatregoryId() {
        return categoryId;
    }

    public void setCatregoryId(int catregoryId) {
        this.categoryId = catregoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
