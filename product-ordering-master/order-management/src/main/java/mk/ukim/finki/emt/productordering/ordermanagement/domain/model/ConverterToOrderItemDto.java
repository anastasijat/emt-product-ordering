package mk.ukim.finki.emt.productordering.ordermanagement.domain.model;

import mk.ukim.finki.emt.productordering.ordermanagement.application.ProductCatalog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ConverterToOrderItemDto {

    private ProductCatalog productCatalog;

    public ConverterToOrderItemDto() {
    }

    public List<OrderItemDTO> convert(List<OrderItem> orderItems)
    {

        List<OrderItemDTO> orderItemDTOS=new ArrayList<>();
        for (OrderItem item: orderItems) {

            Product p=productCatalog.findById(item.getProductId());
            orderItemDTOS.add(new OrderItemDTO(item.getId(),p));
        }
        return orderItemDTOS;
    }
}
