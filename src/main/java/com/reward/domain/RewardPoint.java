package com.reward.domain;

public class RewardPoint {

    private String name;
    private int rewardPoints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    @Override
    public String toString() {
        return "RewardPoint{" +
                "name='" + name + '\'' +
                ", rewardPoints=" + rewardPoints +
                '}';
    }
}
