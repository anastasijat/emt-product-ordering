package mk.ukim.finki.emt.productordering.productcatalog.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.productordering.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class RestaurantId extends DomainObjectId {

    private RestaurantId() {
        super(DomainObjectId.randomId(RestaurantId.class).toString());
    }

    @JsonCreator
    public RestaurantId(String id) {
        super(id);
    }
}
