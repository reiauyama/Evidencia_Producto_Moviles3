package com.example.patata.models;

import java.util.List;

public class VoidTrader {
    private String id;
    private String activation;
    private String startString;
    private String expiry;

    public String getStartString() {
        return startString;
    }

    public void setStartString(String startString) {
        this.startString = startString;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    private boolean active;
    private String character;
    private String location;
    private List<InventoryItem> inventory;

    public List<InventoryItem> getInventory() {
        return inventory;
    }

    public void setInventory(List<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }
// Getters and setters
}
