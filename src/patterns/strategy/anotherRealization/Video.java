package patterns.strategy.anotherRealization;

public class Video implements ComputerStrategy{
    @Override
    public void execute() {
        System.out.println("video");
    }
}
