package com.example.vacation.models;

import java.util.List;
import java.util.Map;

public class BookingDto {
    private Map<Integer, Integer> selectedPackages; // Map of ProductId -> Number of People
    private double totalPrice;
    private double discountedPrice;
    private boolean hasDiscount;

    // Getters and Setters
    public Map<Integer, Integer> getSelectedPackages() {
        return selectedPackages;
    }

    public void setSelectedPackages(Map<Integer, Integer> selectedPackages) {
        this.selectedPackages = selectedPackages;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public boolean isHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }
}