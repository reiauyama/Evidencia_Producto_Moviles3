package com.example.patata.models;

public class Mission {
    private String description;
    private String node;
    private String nodeKey;
    private String type;
    private String typeKey;

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNodeKey() {
        return nodeKey;
    }

    public void setNodeKey(String nodeKey) {
        this.nodeKey = nodeKey;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    private String faction;
    private String factionKey;
    private Reward reward;
    private int minEnemyLevel;
    private int maxEnemyLevel;
    private int maxWaveNum;
    private boolean nightmare;
    private boolean archwingRequired;
    private boolean isSharkwing;
    private String levelOverride;
    private String enemySpec;
}
