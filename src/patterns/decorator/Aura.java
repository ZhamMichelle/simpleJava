package patterns.decorator;

public class Aura extends OptionDecorator{
    public Aura(Service service){
        super(service, 250.0, "aura");
    }
}
