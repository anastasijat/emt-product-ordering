package mk.ukim.finki.emt.productordering.ordermanagement.domain.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.OrderItemId;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.ProductId;
import mk.ukim.finki.emt.productordering.sharedkernel.domain.base.DomainEvent;

import java.time.Instant;

@Getter
public class OrderItemAdded implements DomainEvent {

    @JsonProperty("orderId")
    private final OrderId orderId;

    @JsonProperty
    private final OrderItemId orderItemId;

    @JsonProperty
    private final ProductId productId;

    @JsonProperty("quantity")
    private final int quantity;

    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    public OrderItemAdded(OrderId orderId, OrderItemId orderItemId, ProductId productId, int quantity, Instant occurredOn) {
        this.orderId = orderId;
        this.orderItemId = orderItemId;
        this.productId = productId;
        this.quantity = quantity;
        this.occurredOn = occurredOn;
    }

    @Override
    public Instant occurredOn() {
        return occurredOn;
    }


}
