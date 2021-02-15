package mk.ukim.finki.emt.productordering.productcatalog.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.productordering.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.productordering.sharedkernel.domain.financial.Money;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product extends AbstractEntity<ProductId> {

    @Version
    private Long version;

    @Column(name = "name", nullable = false)
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "currency"))
    })
    private Money price;

    /*@Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "restaurant_name", column = @Column(name = "restaurant_name"))
    })
    private Restaurant restaurant;*/

    //private int quantity;

    private int numOfOrders;

    private int numOfReviews;

    private float averageGrade;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    public Product() {

    }

    public Product(ProductId productId, String name, Money price)
    {
        super(productId);
        this.name = name;
        this.price = price;
        this.numOfOrders=0;
    }


    public int getNumOfOrders() {
        return numOfOrders;
    }

    public void setNumOfOrders(int numOfOrders) {
        this.numOfOrders = numOfOrders;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }


    public void addOrder()
    {
        this.numOfOrders+=1;
    }



    public void addReview()
    {
        this.numOfReviews+=1;
    }

    public void changeAverageGrade(int grade)
    {
        averageGrade=(averageGrade*numOfReviews)+grade;
        addReview();
        averageGrade/=numOfReviews;
    }
}
