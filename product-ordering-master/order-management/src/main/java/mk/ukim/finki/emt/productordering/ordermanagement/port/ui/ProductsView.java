package mk.ukim.finki.emt.productordering.ordermanagement.port.ui;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import mk.ukim.finki.emt.productordering.ordermanagement.application.RestaurantCatalog;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.Product;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.Restaurant;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.RestaurantId;

import java.awt.*;
import java.util.Optional;

@Route("restaurant")
@PageTitle("Show restaurant")
public class ProductsView extends VerticalLayout implements HasUrlParameter<String> {

    private final RestaurantCatalog restaurantCatalog;

    public ProductsView(RestaurantCatalog restaurantCatalog)
    {
        this.restaurantCatalog=restaurantCatalog;
        setSizeFull();

        var title=new Html("<h3>Restaurant</h3>");
        add(title);



        //Label title=new Label("");
        //title.setText("Restaurant");
    }


    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String s) {

        RestaurantId restaurantId=new RestaurantId(s);
        Restaurant r=restaurantCatalog.findById(restaurantId);
        showProducts(r);

    }

    private void showProducts(Restaurant restaurant)
    {

        var title = new Html("<h3>Meals</h3>");
        add(title);

        var items=new Grid<Product>();
        items.addColumn(Product::getName).setHeader("Name");
        items.setItems(restaurant.getProducts());
        add(items);

    }
    private void showNoProducts() {
        add(new Text("There are no products"));
    }

}
