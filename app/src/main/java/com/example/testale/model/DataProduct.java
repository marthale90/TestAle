package com.example.testale.model;

/**
 * Created by Martha Toledano on 16/11/2017.
 */

public class DataProduct {
    private String image;
    private int linioPlusLevel;
    private String conditionType;
    private boolean isFreeShipping;
    private boolean isImported;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLinioPlusLevel() {
        return linioPlusLevel;
    }

    public void setLinioPlusLevel(int linioPlusLevel) {
        this.linioPlusLevel = linioPlusLevel;
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public boolean isFreeShipping() {
        return isFreeShipping;
    }

    public void setFreeShipping(boolean freeShipping) {
        isFreeShipping = freeShipping;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }
}
