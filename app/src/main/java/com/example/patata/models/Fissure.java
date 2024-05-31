package com.example.patata.models;

public class Fissure {
    private String node;
    private String missionType;
    private String enemy;
    private String tier;

    public Fissure(String node, String missionType, String enemy, String tier) {
        this.node = node;
        this.missionType = missionType;
        this.enemy = enemy;
        this.tier = tier;
    }

    public String getNode() {
        return node;
    }

    public String getMissionType() {
        return missionType;
    }

    public String getEnemy() {
        return enemy;
    }

    public String getTier() {
        return tier;
    }
}
