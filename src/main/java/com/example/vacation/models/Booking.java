package com.example.vacation.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.Date;

//@Entity
//@Table(name = "bookings")
//public class Booking {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToMany
//    @JoinTable(
//            name = "booking_products",
//            joinColumns = @JoinColumn(name = "booking_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
//    private List<Product> products;
//
//    private int numberOfPeople;
//    private double totalPrice;
//    private double discountedPrice;
//    private Date bookingDate;
//    private boolean promotionApplied;
//
//    // Getters and Setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public List<Product> getProducts() { return products; }
//    public void setProducts(List<Product> products) { this.products = products; }
//
//    public int getNumberOfPeople() { return numberOfPeople; }
//    public void setNumberOfPeople(int numberOfPeople) { this.numberOfPeople = numberOfPeople; }
//
//    public double getTotalPrice() { return totalPrice; }
//    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
//
//    public double getDiscountedPrice() { return discountedPrice; }
//    public void setDiscountedPrice(double discountedPrice) { this.discountedPrice = discountedPrice; }
//
//    public Date getBookingDate() { return bookingDate; }
//    public void setBookingDate(Date bookingDate) { this.bookingDate = bookingDate; }
//
//    public boolean isPromotionApplied() { return promotionApplied; }
//    public void setPromotionApplied(boolean promotionApplied) { this.promotionApplied = promotionApplied; }
//}
