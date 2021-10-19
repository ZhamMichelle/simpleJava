package patterns.strategy.anotherRealization;


import java.util.logging.Logger;

public class TheMain {
    public static void main(String[] args) {
        Computer computer=new Computer(new Video());
        Computer computer1=new Computer(()-> Logger.getLogger("dv"));
        computer.runTask();
        computer1.runTask();
    }
}
