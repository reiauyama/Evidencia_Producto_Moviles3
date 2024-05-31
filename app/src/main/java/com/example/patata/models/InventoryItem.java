package com.example.patata.models;

import java.util.List;

public class InventoryItem {
    private String uniqueName;
    private String item;
    private int ducats;
    private int credits;

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getDucats() {
        return ducats;
    }

    public void setDucats(int ducats) {
        this.ducats = ducats;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
// Getters and setters
}

