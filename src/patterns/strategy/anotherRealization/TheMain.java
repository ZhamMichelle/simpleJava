package patterns.strategy.anotherRealization;


import java.util.logging.Logger;

public class TheMain {
    public static void main(String[] args) {
        Computer computer=new Computer(new Video());
        Computer computer1=new Computer(()-> System.out.println("sout"));
        computer.runTask();
        computer1.runTask();
    }
}
