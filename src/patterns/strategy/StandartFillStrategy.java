package patterns.strategy;

public class StandartFillStrategy implements FillStrategy{
    @Override
    public void fill() {
        System.out.println("fill standaert");
    }
}
