package patterns.adapter;

public class IceRoadAdapter implements Road{
    private IceRoad iceRoad;

    public IceRoadAdapter() {
        iceRoad = new IceRoad();
    }

    @Override
    public void run(){
        iceRoad.walk();
    }
}
