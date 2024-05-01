package webservers;

import java.util.Objects;

public class Ingredient {
    String itemdescription;
    int quantity;

    public Ingredient(String itemdescription, int quantity) {
        this.itemdescription = itemdescription;
        this.quantity = quantity;
    }

    public Ingredient() {
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient that)) return false;
        return getQuantity() == that.getQuantity() && Objects.equals(getItemdescription(), that.getItemdescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemdescription(), getQuantity());
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "itemdescription='" + itemdescription + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
