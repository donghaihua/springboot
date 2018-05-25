package com.example.springboot.model;

public class ExcelModel {
    private String name;  //cell2
    private String itemName;  //cell 10
    private String specName;   //cell 11
    private Integer residualCount;  //cell 12
    private Double unitPrice;  //cell 13
    private Double totalPrice;  // cell 15
    private Double price;   //cell 17
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getResidualCount() {
        return residualCount;
    }

    public void setResidualCount(Integer residualCount) {
        this.residualCount = residualCount;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
