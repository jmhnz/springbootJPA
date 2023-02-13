package com.springbootpractice.jpa.service;

import com.springbootpractice.jpa.entity.LineItem;
import com.springbootpractice.jpa.entity.Product;
import com.springbootpractice.jpa.entity.Sale;
import com.springbootpractice.jpa.repository.LineItemRepository;
import com.springbootpractice.jpa.repository.ProductRepository;
import com.springbootpractice.jpa.repository.SaleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static java.math.RoundingMode.HALF_UP;

@Service
@Transactional
public class SaleService {

    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;
    private final LineItemRepository lineItemRepository;

    public SaleService(ProductRepository productRepository, SaleRepository saleRepository, LineItemRepository lineItemRepository) {
        this.productRepository = productRepository;
        this.saleRepository = saleRepository;
        this.lineItemRepository = lineItemRepository;
    }

    private static final Integer SCALE = 2;

    public Sale saveOrder(Sale sale){

        List<LineItem> lineItems = sale.getLineItemsList();
        BigDecimal totalPrice = BigDecimal.ZERO;

        if(lineItems == null || lineItems.isEmpty()){
            throw new RuntimeException("Parameters lineItemsList is empty");
        }

        for (LineItem lineItem: lineItems) {

            Optional<Product> productOption = productRepository.findById(lineItem.getProductId());
            if(!productOption.isPresent()){
                throw new RuntimeException("Product ID: "+ lineItem.getProductId() + " Not Found");
            }

            Product product = productOption.get();

            lineItem.setProductName(product.getName());
            lineItem.setProductPrice(product.getPrice());
            BigDecimal subTotal = product.getPrice().multiply(BigDecimal.valueOf(lineItem.getQuantity()));
            lineItem.setSubTotal(subTotal);
            totalPrice = totalPrice.add(subTotal);
        }

        BigDecimal saleDiscount = sale.getSaleDiscount();
        if( saleDiscount != null){
            if( saleDiscount.compareTo(totalPrice) > 0){
                throw new RuntimeException("Parameters saleDiscount is Invalid");
            }
            BigDecimal discountProportion = saleDiscount.divide(totalPrice, SCALE, HALF_UP);
            BigDecimal discountCount = BigDecimal.ZERO;

            for (Integer i =0; i <lineItems.size(); i++) {
                if(i.equals(lineItems.size()-1)){
                    BigDecimal lastItemDiscount = saleDiscount.subtract(discountCount);
                    lineItems.get(i).setItemDiscount(lastItemDiscount);
                    lineItems.get(i).setSubTotal(lineItems.get(i).getSubTotal().subtract(lastItemDiscount));
                    break;
                }
                BigDecimal itemDiscount = lineItems.get(i).getSubTotal().multiply(discountProportion).setScale(SCALE, HALF_UP);
                lineItems.get(i).setItemDiscount(itemDiscount);
                lineItems.get(i).setSubTotal(lineItems.get(i).getSubTotal().subtract(itemDiscount));
                discountCount = discountCount.add(itemDiscount);
            }
            totalPrice = totalPrice.subtract(saleDiscount);
        }else{
            sale.setSaleDiscount(BigDecimal.ZERO);
        }

        sale.setTotalPrice(totalPrice);

        // todo Set Transactional
        saleRepository.save(sale);

        for (LineItem lineItem : lineItems) {
            lineItem.setOrderId(sale.getId());
            if(lineItem.getItemDiscount() == null){
                lineItem.setItemDiscount(BigDecimal.ZERO);
            }
        }
        lineItemRepository.saveAll(lineItems);

        sale.setLineItemsList(lineItems);

        return sale;
    }

    public Sale getSaleDetail(Long id){
        Sale sale = saleRepository.findById(id).get();
        sale.setLineItemsList(lineItemRepository.findLineItems(id));

        return sale;
    }
}
