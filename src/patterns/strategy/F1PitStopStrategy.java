package patterns.strategy;

public class F1PitStopStrategy implements FillStrategy{
    @Override
    public void fill() {
        System.out.println("fil f1");
    }
}
