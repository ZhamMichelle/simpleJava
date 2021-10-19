package patterns.decorator;

public class Horoscope implements Service{
    private Double price;
    private String label;

    public Horoscope(Double price, String label) {
        this.price = price;
        this.label = label;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
