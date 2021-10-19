package patterns.strategy;

public class Sedan extends Auto{
    public Sedan(){
        this.fillStrategy=new StandartFillStrategy();
    }
}
