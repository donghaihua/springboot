package com.example.springboot.model;

import java.io.Serializable;
import java.util.Date;

public class TblSaleOrderDetail implements Serializable {
    private Long id;

    private Long orderId;

    private Long shopId;

    private Long itemId;

    private Long specId;

    private Double totalPrice;

    private Double unitPrice;

    private Double discount;

    private Long totalCredit;

    private Long unitCredit;

    private Integer quantity;

    private Double fxProfit;

    private Double fxProfitUp;

    private Double fxProfitUpUp;

    private String state;

    private Double profit;

    private Double profitUp;

    private Double profitUpUp;

    private Date updateTime;

    private String specName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Long getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(Long totalCredit) {
        this.totalCredit = totalCredit;
    }

    public Long getUnitCredit() {
        return unitCredit;
    }

    public void setUnitCredit(Long unitCredit) {
        this.unitCredit = unitCredit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getFxProfit() {
        return fxProfit;
    }

    public void setFxProfit(Double fxProfit) {
        this.fxProfit = fxProfit;
    }

    public Double getFxProfitUp() {
        return fxProfitUp;
    }

    public void setFxProfitUp(Double fxProfitUp) {
        this.fxProfitUp = fxProfitUp;
    }

    public Double getFxProfitUpUp() {
        return fxProfitUpUp;
    }

    public void setFxProfitUpUp(Double fxProfitUpUp) {
        this.fxProfitUpUp = fxProfitUpUp;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getProfitUp() {
        return profitUp;
    }

    public void setProfitUp(Double profitUp) {
        this.profitUp = profitUp;
    }

    public Double getProfitUpUp() {
        return profitUpUp;
    }

    public void setProfitUpUp(Double profitUpUp) {
        this.profitUpUp = profitUpUp;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }
}