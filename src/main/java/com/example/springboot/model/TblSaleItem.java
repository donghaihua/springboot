package com.example.springboot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TblSaleItem implements Serializable {
    private Long id;

    private Long shopId;

    private String brand;

    private Long seriesId;

    private String itemName;

    private String avatar;

    private String sellingPoints;

    private Double minOriginalprice;

    private Double maxOriginalprice;

    private Double minDiscountprice;

    private Double maxDiscountprice;

    private Double minVolume;

    private Double maxVolume;

    private Long minCreditPrice;

    private Long maxCreditPrice;

    private String rawMaterial;

    private String packing;

    private String technology;

    private String inventory;

    private Date releaseDate;

    private Date registerDate;

    private Integer type;

    private Integer state;

    private String seoTitle;

    private String seoDescription;

    private String seoKeywords;

    private Integer refundFlag;

    private Integer rewardFlag;
	
    private String avatar2;

    private String avatar3;

    private String avatar4;

    //<-- added
    /*private TblSaleShopSeries saleShopSeries;

    private TblSaleItemDetail saleItemDetail;

    private List<TblSaleItemSpec> saleItemSpecList;

    private Set<TblSaleLabel> saleLabels2 = new HashSet<>(0);

    private List<TblSaleLabelItem> saleLabels;
    //一级提点，二级提点  Hayward
    private TblDistributionItemProfit itemProfit;*/

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public Long getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Long seriesId) {
        this.seriesId = seriesId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getSellingPoints() {
        return sellingPoints;
    }

    public void setSellingPoints(String sellingPoints) {
        this.sellingPoints = sellingPoints == null ? null : sellingPoints.trim();
    }

    public Double getMinOriginalprice() {
        return minOriginalprice;
    }

    public void setMinOriginalprice(Double minOriginalprice) {
        this.minOriginalprice = minOriginalprice;
    }

    public Double getMaxOriginalprice() {
        return maxOriginalprice;
    }

    public void setMaxOriginalprice(Double maxOriginalprice) {
        this.maxOriginalprice = maxOriginalprice;
    }

    public Double getMinDiscountprice() {
        return minDiscountprice;
    }

    public void setMinDiscountprice(Double minDiscountprice) {
        this.minDiscountprice = minDiscountprice;
    }

    public Double getMaxDiscountprice() {
        return maxDiscountprice;
    }

    public void setMaxDiscountprice(Double maxDiscountprice) {
        this.maxDiscountprice = maxDiscountprice;
    }

    public Double getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(Double minVolume) {
        this.minVolume = minVolume;
    }

    public Double getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(Double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public Long getMinCreditPrice() {
        return minCreditPrice;
    }

    public void setMinCreditPrice(Long minCreditPrice) {
        this.minCreditPrice = minCreditPrice;
    }

    public Long getMaxCreditPrice() {
        return maxCreditPrice;
    }

    public void setMaxCreditPrice(Long maxCreditPrice) {
        this.maxCreditPrice = maxCreditPrice;
    }

    public String getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(String rawMaterial) {
        this.rawMaterial = rawMaterial == null ? null : rawMaterial.trim();
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing == null ? null : packing.trim();
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology == null ? null : technology.trim();
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory == null ? null : inventory.trim();
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle == null ? null : seoTitle.trim();
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription == null ? null : seoDescription.trim();
    }

    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords == null ? null : seoKeywords.trim();
    }

    //<-- added
    /*public TblSaleShopSeries getSaleShopSeries() {
        return saleShopSeries;
    }

    public void setSaleShopSeries(TblSaleShopSeries saleShopSeries) {
        this.saleShopSeries = saleShopSeries;
    }

    public TblSaleItemDetail getSaleItemDetail() {
        return saleItemDetail;
    }

    public void setSaleItemDetail(TblSaleItemDetail saleItemDetail) {
        this.saleItemDetail = saleItemDetail;
    }

    public List<TblSaleItemSpec> getSaleItemSpecList() {
        return saleItemSpecList;
    }

    public void setSaleItemSpecList(List<TblSaleItemSpec> saleItemSpecList) {
        this.saleItemSpecList = saleItemSpecList;
    }

    public Set<TblSaleLabel> getSaleLabels2() {
        return saleLabels2;
    }

    public void setSaleLabels2(Set<TblSaleLabel> saleLabels2) {
        this.saleLabels2 = saleLabels2;
    }

    public List<TblSaleLabelItem> getSaleLabels() {
        return saleLabels;
    }

    public void setSaleLabels(List<TblSaleLabelItem> saleLabels) {
        this.saleLabels = saleLabels;
    }*/

    public Integer getRefundFlag() {
        return refundFlag;
    }

    public void setRefundFlag(Integer refundFlag) {
        this.refundFlag = refundFlag;
    }

    public Integer getRewardFlag() {
        return rewardFlag;
    }

    public void setRewardFlag(Integer rewardFlag) {
        this.rewardFlag = rewardFlag;
    }

    public String getAvatar2() {
        return avatar2;
    }

    public void setAvatar2(String avatar2) {
        this.avatar2 = avatar2 == null ? null : avatar2.trim();
    }

    public String getAvatar3() {
        return avatar3;
    }

    public void setAvatar3(String avatar3) {
        this.avatar3 = avatar3 == null ? null : avatar3.trim();
    }

    public String getAvatar4() {
        return avatar4;
    }

    public void setAvatar4(String avatar4) {
        this.avatar4 = avatar4 == null ? null : avatar4.trim();
    }

    /*public TblDistributionItemProfit getItemProfit() {
        return itemProfit;
    }

    public void setItemProfit(TblDistributionItemProfit itemProfit) {
        this.itemProfit = itemProfit;
    }*/
}