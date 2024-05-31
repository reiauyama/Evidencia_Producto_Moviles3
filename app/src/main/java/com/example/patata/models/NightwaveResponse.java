package com.example.patata.models;

import java.util.List;



public class NightwaveResponse {
    private String id;
    private String activation;
    private String startString;
    private String expiry;
    private boolean active;
    private int season;

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }



    public void setPossibleChallenges(List<Challenge> possibleChallenges) {
        this.possibleChallenges = possibleChallenges;
    }

    public List<Challenge> getActiveChallenges() {
        return activeChallenges;
    }


    public void setActiveChallenges(List<Challenge> activeChallenges) {
        this.activeChallenges = activeChallenges;
    }

    public List<String> getRewardTypes() {
        return rewardTypes;
    }

    public void setRewardTypes(List<String> rewardTypes) {
        this.rewardTypes = rewardTypes;
    }

    private String tag;
    private int phase;
    private List<Challenge> possibleChallenges;
    private List<Challenge> activeChallenges;
    private List<String> rewardTypes;
}

