public class LineItem {
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return product.getUnitPrice() * quantity;
    }

    public String toString() {
        return quantity + " x " + product.getName() + " @ $" + product.getUnitPrice() + " = $" + getTotal();
    }
}
