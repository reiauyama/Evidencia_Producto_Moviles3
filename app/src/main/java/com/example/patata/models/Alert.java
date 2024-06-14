package com.example.patata.models;

public class Alert {
    private String id;
    private String activation;
    private String startString;
    private String expiry;
    private boolean active;
    private Mission mission;

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    private String eta;
    private String[] rewardTypes;
    private String tag;
}
