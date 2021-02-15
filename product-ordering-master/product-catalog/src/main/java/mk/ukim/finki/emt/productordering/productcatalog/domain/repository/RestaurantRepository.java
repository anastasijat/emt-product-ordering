package mk.ukim.finki.emt.productordering.productcatalog.domain.repository;

import mk.ukim.finki.emt.productordering.productcatalog.domain.model.Restaurant;
import mk.ukim.finki.emt.productordering.productcatalog.domain.model.RestaurantId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, RestaurantId> {
}
