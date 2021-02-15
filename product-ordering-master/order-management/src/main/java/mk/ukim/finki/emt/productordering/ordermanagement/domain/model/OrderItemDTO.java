package mk.ukim.finki.emt.productordering.ordermanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.productordering.ordermanagement.application.ProductCatalog;

@Getter
public class OrderItemDTO {

    private OrderItemId orderItemId;
    private Product product;
    private static ProductCatalog productCatalog;

    public OrderItemDTO(OrderItemId orderItemId, Product product) {
        this.orderItemId = orderItemId;
        this.product = product;
    }

    public String getProductName()
    {
        return product.getName();
    }



}
