package com.trainingapps.productms.dto;

import javax.validation.constraints.Min;

public class ChangeProductRequest {
    @Min(0)
    private double newPrice;

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }
}
