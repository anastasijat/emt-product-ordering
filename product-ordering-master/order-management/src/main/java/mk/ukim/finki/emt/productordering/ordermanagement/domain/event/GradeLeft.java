package mk.ukim.finki.emt.productordering.ordermanagement.domain.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.ProductId;
import mk.ukim.finki.emt.productordering.sharedkernel.domain.base.DomainEvent;

import java.time.Instant;

@Getter
public class GradeLeft implements DomainEvent {

    @JsonProperty
    private final ProductId productId;

    @JsonProperty("grade")
    private final int grade;

    @JsonProperty("occurredOn")
    private final Instant occurredOn;


    public GradeLeft(ProductId productId, int grade, Instant occurredOn) {
        this.productId = productId;
        this.grade = grade;
        this.occurredOn = occurredOn;
    }

    @Override
    @NonNull
    public Instant occurredOn() {
        return occurredOn;
    }
}
