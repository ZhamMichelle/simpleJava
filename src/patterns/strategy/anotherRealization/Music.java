package patterns.strategy.anotherRealization;

public class Music implements ComputerStrategy{
    @Override
    public void execute() {
        System.out.println("music");
    }
}
