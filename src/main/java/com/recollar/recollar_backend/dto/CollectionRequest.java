package com.recollar.recollar_backend.dto;

public class CollectionRequest {
    private int idCollection;
    private String name;
    private int idCategory;

    public int getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(int idCollection) {
        this.idCollection = idCollection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
