package mk.ukim.finki.emt.productordering.ordermanagement.application.form;

import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.Restaurant;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class RestaurantForm implements Serializable {

    @NotNull
    private Restaurant restaurant;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
