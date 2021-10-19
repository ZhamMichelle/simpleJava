package patterns.decorator;

public class OptionDecorator implements Service{
    private Service service;
    private Double price;
    private String label;

    public OptionDecorator(Service service, Double price, String label) {
        this.service = service;
        this.price = price;
        this.label = label;
    }

    @Override
    public Double getPrice() {
        return price+ service.getPrice();
    }

    @Override
    public String getLabel() {
        return label+service.getLabel();
    }
}
