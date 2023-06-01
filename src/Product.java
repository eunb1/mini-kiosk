import java.util.*;

public class Product extends Menu {
    private double price;
    private List<Option> options = new ArrayList<>();

    public Product(String name, double price, String description) {
        super(name, description);
        this.price = price;
    }

    public Product(String name, double price, String description, List<Option> options) {
        super(name, description);
        this.price = price;
        this.options = options;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return super.getName();
    }

    public String getDescription() {
        return super.getDescription();
    }

    public  List<Option> getOptions() {
        return options;
    }

    public boolean hasOptions() {
        return !options.isEmpty();
    }
}
