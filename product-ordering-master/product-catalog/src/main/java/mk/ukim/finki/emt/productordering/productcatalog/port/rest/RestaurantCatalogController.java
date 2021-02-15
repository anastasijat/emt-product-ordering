package mk.ukim.finki.emt.productordering.productcatalog.port.rest;

import mk.ukim.finki.emt.productordering.productcatalog.application.RestaurantCatalog;
import mk.ukim.finki.emt.productordering.productcatalog.domain.model.Restaurant;
import mk.ukim.finki.emt.productordering.productcatalog.domain.model.RestaurantId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantCatalogController {
    private final RestaurantCatalog restaurantCatalog;

    public RestaurantCatalogController(RestaurantCatalog restaurantCatalog) {
        this.restaurantCatalog = restaurantCatalog;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findById(@PathVariable("id") String restaurantId) {
        return restaurantCatalog.findById(new RestaurantId(restaurantId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Restaurant> findAll() {
        return restaurantCatalog.findAll();
    }

}
