package com.recollar.recollar_backend.dto;

public class CollectionRequest {
    private int idCollector;
    private String name;
    private String color;
    private int amount;

    public CollectionRequest() {
    }

    public int getIdCollector() {
        return idCollector;
    }

    public void setIdCollector(int idCollector) {
        this.idCollector = idCollector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
