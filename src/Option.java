public class Option extends Product {
    private final String tag;

    public Option(String tag, String fullName, double price, String description) {
        super(fullName, price, description);
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }
}
