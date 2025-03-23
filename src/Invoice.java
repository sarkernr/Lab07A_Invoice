import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private List<LineItem> lineItems;

    public Invoice() {
        lineItems = new ArrayList<>();
    }

    public void addLineItem(LineItem item) {
        lineItems.add(item);
    }

    public double getTotal() {
        return lineItems.stream().mapToDouble(LineItem::getTotal).sum();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LineItem item : lineItems) {
            sb.append(item).append("\n");
        }
        sb.append("Total Amount Due: $").append(getTotal());
        return sb.toString();
    }
}
