package patterns.adapter;

public class TheMain extends AbstractOrderParameterValueResolver<Runner>{
    public static void main(String[] args) {
        Runner runner=new Runner(new IceRoadAdapter());
        runner.runOnTheRoad();
    }
}
