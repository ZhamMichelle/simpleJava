package patterns.strategy.anotherRealization;

public class Computer {
    ComputerStrategy computerStrategy;

    public Computer(ComputerStrategy computerStrategy) {
        this.computerStrategy = computerStrategy;
    }

    public void setComputerStrategy(ComputerStrategy computerStrategy) {
        this.computerStrategy = computerStrategy;
    }

    public void runTask(){
        computerStrategy.execute();
    }
}
