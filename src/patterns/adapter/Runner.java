package patterns.adapter;

public class Runner {
    private Road road;

    public Runner() {
    }

    public Runner(Road road) {
        this.road = road;
    }

    public void runOnTheRoad(){
        road.run();
    }

    public void test(){
        System.out.println(this.getClass().getSimpleName());
    }
}
