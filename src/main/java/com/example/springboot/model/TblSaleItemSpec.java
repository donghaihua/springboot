package com.example.springboot.model;

import java.io.Serializable;

public class TblSaleItemSpec implements Serializable {
    private Long id;

    private Long shopId;

    private Long itemId;

    private String specName;

    private String avatar;

    private Double originalPrice;

    private Double discount;

    private Double discountPrice;

    private Long creditPrice;

    private Integer inventory;

    private Integer state;

    private Long ticketId;

    private Integer operation;// 1新增，2修改，3删除

    //此规格在订单中的总量   ----hayward
    private Integer orderCount;
    //此规格在订单中的剩余量   ---hayward
    private Integer residualCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Long getCreditPrice() {
        return creditPrice;
    }

    public void setCreditPrice(Long creditPrice) {
        this.creditPrice = creditPrice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getResidualCount() {
        return residualCount;
    }

    public void setResidualCount(Integer residualCount) {
        this.residualCount = residualCount;
    }
}