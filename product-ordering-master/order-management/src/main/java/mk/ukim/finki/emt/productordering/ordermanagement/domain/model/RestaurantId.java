package mk.ukim.finki.emt.productordering.ordermanagement.domain.model;

import mk.ukim.finki.emt.productordering.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class RestaurantId extends DomainObjectId {


    public RestaurantId(String id) {
        super(id);
    }
}
