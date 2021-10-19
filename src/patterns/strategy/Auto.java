package patterns.strategy;

public class Auto {
    FillStrategy fillStrategy;

    public void fill(){
        fillStrategy.fill();
    }
    public void gas(){
        System.out.println("gas");
    }
    public void stop(){
        System.out.println("stop");
    }

    public void setFillStrategy(FillStrategy fillStrategy) {
        this.fillStrategy = fillStrategy;
    }
}
