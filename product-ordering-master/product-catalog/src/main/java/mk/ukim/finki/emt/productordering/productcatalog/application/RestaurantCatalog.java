package mk.ukim.finki.emt.productordering.productcatalog.application;

import mk.ukim.finki.emt.productordering.productcatalog.domain.model.Product;
import mk.ukim.finki.emt.productordering.productcatalog.domain.model.ProductId;
import mk.ukim.finki.emt.productordering.productcatalog.domain.model.Restaurant;
import mk.ukim.finki.emt.productordering.productcatalog.domain.model.RestaurantId;
import mk.ukim.finki.emt.productordering.productcatalog.domain.repository.ProductRepository;
import mk.ukim.finki.emt.productordering.productcatalog.domain.repository.RestaurantRepository;
import mk.ukim.finki.emt.productordering.productcatalog.integration.GradeLeftEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class RestaurantCatalog {
    private final RestaurantRepository restaurantRepository;

    public RestaurantCatalog(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @NonNull
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @NonNull
    public Optional<Restaurant> findById(@NonNull RestaurantId restaurantId) {
        Objects.requireNonNull(restaurantId, "restaurantId must not be null");
        return restaurantRepository.findById(restaurantId);
    }

}
