package com.example.testale.Commons;

/**
 * Created by Martha Toledano on 16/11/2017.
 */

public class ProductAttributes {
    private int plusLevelProduct;
    private int conditionProduct;
    private int importProduct;
    private int freeShippingProduct;

    public ProductAttributes() {
        this.plusLevelProduct = Constants.NO_SHOW;
        this.conditionProduct = Constants.NO_SHOW;
        this.importProduct = Constants.NO_SHOW;
        this.freeShippingProduct = Constants.NO_SHOW;
    }

    public int getPlusLevelProduct() {
        return plusLevelProduct;
    }

    public void setPlusLevelProduct(int plusLevelProduct) {
        this.plusLevelProduct = plusLevelProduct;
    }

    public int getConditionProduct() {
        return conditionProduct;
    }

    public void setConditionProduct(int conditionProduct) {
        this.conditionProduct = conditionProduct;
    }

    public int getImportProduct() {
        return importProduct;
    }

    public void setImportProduct(int importProduct) {
        this.importProduct = importProduct;
    }

    public int getFreeShippingProduct() {
        return freeShippingProduct;
    }

    public void setFreeShippingProduct(int freeShippingProduct) {
        this.freeShippingProduct = freeShippingProduct;
    }
}
