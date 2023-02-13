package com.springbootpractice.jpa.entity;


import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BigDecimal totalPrice;

    @Column
    @DecimalMin(message = "Invalid SaleDiscount", value = "0")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal saleDiscount;

    @Transient
    private List<LineItem> lineItemsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getSaleDiscount() {
        return saleDiscount;
    }

    public void setSaleDiscount(BigDecimal saleDiscount) {
        this.saleDiscount = saleDiscount;
    }

    @Transient
    public List<LineItem> getLineItemsList() {
        return lineItemsList;
    }

    public void setLineItemsList(List<LineItem> lineItemsList) {
        this.lineItemsList = lineItemsList;
    }


    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", saleDiscount=" + saleDiscount +
                ", lineItemsList=" + lineItemsList +
                '}';
    }
}
