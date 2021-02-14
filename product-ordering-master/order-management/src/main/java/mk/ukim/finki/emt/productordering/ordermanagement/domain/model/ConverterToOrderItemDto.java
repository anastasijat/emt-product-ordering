package mk.ukim.finki.emt.productordering.ordermanagement.domain.model;

import mk.ukim.finki.emt.productordering.ordermanagement.application.ProductCatalog;

import javax.servlet.http.PushBuilder;
import java.util.ArrayList;
import java.util.List;

public class ConverterToOrderItemDto {

    private ProductCatalog productCatalog;

    public ConverterToOrderItemDto() {
    }

    public List<OrderItemDTO> convert(List<OrderItem> orderItem)
    {

        List<OrderItemDTO> orderItemDTOS=new ArrayList<>();
        for (OrderItem item: orderItem) {

            orderItemDTOS.add(new OrderItemDTO(item.getId(),productCatalog.findById(item.getProductId())));
        }
        return orderItemDTOS;
    }
}
