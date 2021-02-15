package mk.ukim.finki.emt.productordering.ordermanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.productordering.ordermanagement.application.RestaurantCatalog;
import mk.ukim.finki.emt.productordering.sharedkernel.domain.geo.Address;

import java.util.Set;

@Getter
public class Restaurant {

    private String name;
    private RestaurantId restaurantId;
    private Address address;
    private Set<Product> products;

}
