package mk.ukim.finki.emt.productordering.productcatalog.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.productordering.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.productordering.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.productordering.sharedkernel.domain.geo.Address;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractEntity<RestaurantId> {

    @Column(name="name",nullable = false)
    private String name;

    @Column(name = "address")
    @Embedded
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Product> products;


    public Restaurant() {
    }

    public Restaurant(RestaurantId restaurantId,@NonNull  String name, @NonNull  Address address) {
        super(restaurantId);
        this.products=new HashSet<>();
        this.name = name;
        this.address = address;

    }

    public Restaurant(@NonNull  String name, @NonNull  Address address) {
        this.name = name;
        this.address = address;

    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void addProduct(Product product)
    {
        this.products.add(product);
    }
    @NonNull
    @JsonProperty("address")
    public Address address() {
        return address;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(name, that.name) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", address=" + address;
    }
}
