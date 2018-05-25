package com.example.springboot.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TblSaleOrder implements Serializable {
    private Long id;

    private Long parentId;

    private Long accountId;

    private String nickname;

    private Long fxUserId;

    private Long fxUserIdUp;

    private Long fxUserIdUpUp;

    private Double fxProfit;

    private Double fxProfitUp;

    private Double fxProfitUpUp;

    private Integer withdrawCash;

    private Integer withdrawCashUp;

    private Integer withdrawCashUpUp;

    private Long shopId;

    private Integer payType;

    private Integer paySubType;

    private String tradeno;

    private String ordername;

    private String orderno;

    private String address;

    private String postcode;

    private String recipient;

    private String telephone;

    private String phone;

    private Long ticketId;

    private Integer credits;

    private Double difference;

    private Double totalprice;

    private Integer logisticsId;

    private String logisticsName;

    private String logistics;

    private Integer delivery;

    private Integer invoiceType;

    private String invoiceTitle;

    private String remarks;

    private String remarksShop;

    private Date createdate;

    private Date dealdate;

    private Date notPayCancelDate;

    private String cancelReason;

    private Integer type;

    private Integer saleItemType;

    private Double returnMoney;

    private String returnRemark;

    private Integer state;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Long getFxUserId() {
        return fxUserId;
    }

    public void setFxUserId(Long fxUserId) {
        this.fxUserId = fxUserId;
    }

    public Long getFxUserIdUp() {
        return fxUserIdUp;
    }

    public void setFxUserIdUp(Long fxUserIdUp) {
        this.fxUserIdUp = fxUserIdUp;
    }

    public Long getFxUserIdUpUp() {
        return fxUserIdUpUp;
    }

    public void setFxUserIdUpUp(Long fxUserIdUpUp) {
        this.fxUserIdUpUp = fxUserIdUpUp;
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

    public Integer getWithdrawCash() {
        return withdrawCash;
    }

    public void setWithdrawCash(Integer withdrawCash) {
        this.withdrawCash = withdrawCash;
    }

    public Integer getWithdrawCashUp() {
        return withdrawCashUp;
    }

    public void setWithdrawCashUp(Integer withdrawCashUp) {
        this.withdrawCashUp = withdrawCashUp;
    }

    public Integer getWithdrawCashUpUp() {
        return withdrawCashUpUp;
    }

    public void setWithdrawCashUpUp(Integer withdrawCashUpUp) {
        this.withdrawCashUpUp = withdrawCashUpUp;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getPaySubType() {
        return paySubType;
    }

    public void setPaySubType(Integer paySubType) {
        this.paySubType = paySubType;
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno == null ? null : tradeno.trim();
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername == null ? null : ordername.trim();
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient == null ? null : recipient.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Double getDifference() {
        return difference;
    }

    public void setDifference(Double difference) {
        this.difference = difference;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Integer logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName == null ? null : logisticsName.trim();
    }

    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistics) {
        this.logistics = logistics == null ? null : logistics.trim();
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getRemarksShop() {
        return remarksShop;
    }

    public void setRemarksShop(String remarksShop) {
        this.remarksShop = remarksShop == null ? null : remarksShop.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getDealdate() {
        return dealdate;
    }

    public void setDealdate(Date dealdate) {
        this.dealdate = dealdate;
    }

    public Date getNotPayCancelDate() {
        return notPayCancelDate;
    }

    public void setNotPayCancelDate(Date notPayCancelDate) {
        this.notPayCancelDate = notPayCancelDate;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason == null ? null : cancelReason.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSaleItemType() {
        return saleItemType;
    }

    public void setSaleItemType(Integer saleItemType) {
        this.saleItemType = saleItemType;
    }

    public Double getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(Double returnMoney) {
        this.returnMoney = returnMoney;
    }

    public String getReturnRemark() {
        return returnRemark;
    }

    public void setReturnRemark(String returnRemark) {
        this.returnRemark = returnRemark == null ? null : returnRemark.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }



}
