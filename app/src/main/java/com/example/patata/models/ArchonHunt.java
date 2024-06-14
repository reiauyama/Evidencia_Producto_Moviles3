package com.example.patata.models;

import java.util.List;

public class ArchonHunt {
    private String boss;
    private String faction;
    private String eta;

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public List<MissionArchontHunt> getMissions() {
        return missions;
    }

    public void setMissions(List<MissionArchontHunt> missions) {
        this.missions = missions;
    }

    private List<MissionArchontHunt> missions;
}

