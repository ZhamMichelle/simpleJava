package patterns.decorator;

public class Devination implements Service{
    private Double price;
    private String label;

    public Devination(Double price, String label){
        this.price=price;
        this.label=label;
    }

    @Override
    public Double getPrice(){
        return price;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
