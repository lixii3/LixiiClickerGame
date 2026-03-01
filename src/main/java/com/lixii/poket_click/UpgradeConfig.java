package com.lixii.poket_click;

public class UpgradeConfig {
    private String text;
    private int cost;
    private double benefit;
    
    public UpgradeConfig(String text, int cost, double benefit) {
        this.text = text;
        this.cost = cost;
        this.benefit = benefit;
    }
    
    public String getText() {
        return text;
    }
    
    public int getCost() {
        return cost;
    }
    
    public double getBenefit() {
        return benefit;
    }
}
