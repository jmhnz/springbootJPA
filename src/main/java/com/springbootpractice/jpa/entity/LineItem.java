package com.springbootpractice.jpa.entity;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long orderId;

    @Column
    @NotNull
    private Long productId;

    @Column(columnDefinition = "0")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal itemDiscount;

    @Column
    private String productName;

    @Column
    @Digits(integer = 10, fraction = 2)
    private BigDecimal productPrice;

    @Column
    @NotNull
    private Long quantity;

    @Column
    private BigDecimal subTotal;

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getItemDiscount() {
        return itemDiscount;
    }

    public void setItemDiscount(BigDecimal itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", itemDiscount=" + itemDiscount +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", quantity=" + quantity +
                ", subTotal=" + subTotal +
                '}';
    }
}
