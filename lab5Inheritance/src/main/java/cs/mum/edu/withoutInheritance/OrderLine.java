package cs.mum.edu.withoutInheritance;

import javax.persistence.*;

//@Entity
public class OrderLine {
    @Id
    @GeneratedValue
    private int id;
    private int quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Quantity: "+getQuantity()+"Product Name: "+getProduct().getName()+"Product Description: "+getProduct().getDescription();
    }
}
