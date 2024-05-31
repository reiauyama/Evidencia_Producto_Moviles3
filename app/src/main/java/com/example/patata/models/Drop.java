package com.example.patata.models;

public class Drop {
    private String place;
    private String item;
    private String rarity;
    private double chance;

    public Drop(String place, String item, String rarity, double chance) {
        this.place = place;
        this.item = item;
        this.rarity = rarity;
        this.chance = chance;
    }

    public String getPlace() {
        return place;
    }

    public String getItem() {
        return item;
    }

    public String getRarity() {
        return rarity;
    }

    public double getChance() {
        return chance;
    }
}
