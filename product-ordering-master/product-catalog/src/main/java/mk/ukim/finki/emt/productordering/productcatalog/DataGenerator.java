package mk.ukim.finki.emt.productordering.productcatalog;

import mk.ukim.finki.emt.productordering.productcatalog.domain.model.Product;
import mk.ukim.finki.emt.productordering.productcatalog.domain.model.ProductId;
import mk.ukim.finki.emt.productordering.productcatalog.domain.model.RestaurantId;
import mk.ukim.finki.emt.productordering.productcatalog.domain.repository.ProductRepository;
import mk.ukim.finki.emt.productordering.productcatalog.domain.repository.RestaurantRepository;
import mk.ukim.finki.emt.productordering.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.productordering.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.productordering.sharedkernel.domain.geo.Address;
import mk.ukim.finki.emt.productordering.sharedkernel.domain.geo.City;
import mk.ukim.finki.emt.productordering.sharedkernel.domain.geo.Country;
import mk.ukim.finki.emt.productordering.productcatalog.domain.model.Restaurant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
class DataGenerator {

    private final ProductRepository productRepository;
    private final RestaurantRepository restaurantRepository;

    DataGenerator(ProductRepository productRepository,RestaurantRepository restaurantRepository) {
        this.productRepository = productRepository;
        this.restaurantRepository=restaurantRepository;
    }

    @PostConstruct
    @Transactional
    public void generateData() {
        if (productRepository.findAll().size()==0) {
            var products = new ArrayList<Product>();
            products.add(createProduct(new ProductId("1"),"Pizza 1",  new Money(Currency.MKD, 150)));
            products.add(createProduct(new ProductId("2"),"Burger 2",  new Money(Currency.MKD, 150)));
            products.add(createProduct(new ProductId("3"),"Pasta 3",  new Money(Currency.MKD, 150)));
            productRepository.saveAll(products);
        }

        if (restaurantRepository.findAll().size()==0) {
            var restaurants=new ArrayList<Restaurant>();
            Restaurant r1=createRestaurant(new RestaurantId(("4")),"jakomo",new Address("boris trajkovski",new City("Skopje"),Country.MK));
            restaurants.add(r1);
            r1.addProduct(createProduct(new ProductId("5"),"Pizza 5",  new Money(Currency.MKD, 150)));
            restaurantRepository.saveAll(restaurants);

        }



    }

    private Product createProduct(ProductId productId, String name, Money price) {
        var product = new Product(productId,name, price);
        return product;
    }
    private Restaurant createRestaurant(RestaurantId restaurantId, String name, Address address)
    {
        var restaurant=new Restaurant(restaurantId,name,address);
        return restaurant;
    }
}
