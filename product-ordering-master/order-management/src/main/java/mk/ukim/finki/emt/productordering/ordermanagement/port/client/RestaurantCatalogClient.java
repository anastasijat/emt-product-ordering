package mk.ukim.finki.emt.productordering.ordermanagement.port.client;

import mk.ukim.finki.emt.productordering.ordermanagement.application.RestaurantCatalog;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.Product;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.ProductId;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.Restaurant;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.RestaurantId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class RestaurantCatalogClient implements RestaurantCatalog {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCatalogClient.class);

    private final RestTemplate restTemplate;
    private final String serverUrl;

    RestaurantCatalogClient(@Value("${app.product-catalog.url}") String serverUrl,
                         @Value("${app.product-catalog.connect-timeout-ms}") int connectTimeout,
                         @Value("${app.product-catalog.read-timeout-ms}") int readTimeout) {
        this.serverUrl = serverUrl;
        restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        // Never ever do a remote call without a finite timeout!
        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setReadTimeout(readTimeout);
        restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(serverUrl);
    }

    @Override
    public List<Restaurant> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/restaurants").build().toUri(), HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Restaurant>>() {
                    }).getBody();
        } catch (Exception ex) {
            LOGGER.error("Error retrieving restaurants", ex);
            return Collections.emptyList();
        }
    }

    @Override
    public Restaurant findById(RestaurantId id) {
        try {
            return restTemplate.exchange(uri().path("/api/restaurants/"+id.getId()).build().toUri(), HttpMethod.GET, null,
                    new ParameterizedTypeReference<Restaurant>() {
                    }).getBody();
        } catch (Exception ex) {
            LOGGER.error("Error retrieving restaurant by id", ex);
            return null;
        }
    }
}
