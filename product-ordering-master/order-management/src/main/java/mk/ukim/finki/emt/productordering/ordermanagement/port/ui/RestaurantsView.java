package mk.ukim.finki.emt.productordering.ordermanagement.port.ui;

import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import mk.ukim.finki.emt.productordering.ordermanagement.application.RestaurantCatalog;
import mk.ukim.finki.emt.productordering.ordermanagement.application.form.RestaurantForm;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.Restaurant;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.RestaurantId;

import java.awt.*;

@Route("list-restaurants")
@PageTitle("RestaurantsView")
public class RestaurantsView extends VerticalLayout {

    RestaurantCatalog restaurantCatalog;
    private ComboBox<Restaurant> restaurantComboBox;
    private final Binder<RestaurantForm> binder;



    public RestaurantsView(RestaurantCatalog restaurantCatalog)
    {
        this.restaurantCatalog=restaurantCatalog;
        setSizeFull();
        binder=new Binder<>();


        var title=new Html("<h3>Restaurants</h3>");
        add(title);


        restaurantComboBox=new ComboBox<>("Restaurants",restaurantCatalog.findAll());
        restaurantComboBox.setItemLabelGenerator(Restaurant::getName);
        add(restaurantComboBox);
       /* Label lbl=new Label("");
        restaurantComboBox.addValueChangeListener((HasValue.ValueChangeEvent<Restaurant> event)->{
            Restaurant r=event.getValue();
            lbl.setText(r.getName());
        });*/



        //var visitRestaurant=new Button("Visit restaurant",event->getUI().ifPresent(ui -> ui.navigate(ProductsView.class,restaurantComboBox.getValue().getRestaurantId().toString())));

        //restaurantComboBox.addValueChangeListener(evt->visitRestaurant(evt.getValue().getRestaurantId()));








    }



}
