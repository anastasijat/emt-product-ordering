package mk.ukim.finki.emt.productordering.ordermanagement.application.form;

import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.Product;
import mk.ukim.finki.emt.productordering.ordermanagement.domain.model.ProductId;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class GradeForm implements Serializable {

    @NotNull
    private Product product;

    @NotNull
    private int grade;



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
