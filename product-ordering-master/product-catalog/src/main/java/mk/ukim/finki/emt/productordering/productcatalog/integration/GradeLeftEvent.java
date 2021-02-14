package mk.ukim.finki.emt.productordering.productcatalog.integration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.productordering.productcatalog.domain.model.Product;
import mk.ukim.finki.emt.productordering.productcatalog.domain.model.ProductId;
import mk.ukim.finki.emt.productordering.sharedkernel.domain.base.DomainEvent;
import org.atmosphere.config.service.Get;

import java.time.Instant;

@Getter
public class GradeLeftEvent implements DomainEvent {

    @JsonProperty("productId")
    private final ProductId productId;

    @JsonProperty("grade")
    private final int grade;

    @JsonProperty("occurredOn")
    private final Instant occurredOn;


    @JsonCreator

    public GradeLeftEvent(ProductId productId, int grade,Instant occurredOn) {
        this.productId = productId;
        this.grade = grade;
        this.occurredOn=occurredOn;
    }

    @Override
    public Instant occurredOn() {
        return null;
    }
}
