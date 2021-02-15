package mk.ukim.finki.emt.productordering.ordermanagement.application;


import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.Restaurant;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.RestaurantId;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface RestaurantCatalog {

    List<Restaurant> findAll();

    Restaurant findById(RestaurantId id);

}
