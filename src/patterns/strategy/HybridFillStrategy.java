package patterns.strategy;

public class HybridFillStrategy implements FillStrategy{
    @Override
    public void fill() {
        System.out.println("fill hybrid");
    }
}
