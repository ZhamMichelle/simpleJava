package patterns.adapter;

public class IceRoad extends AbstractOrderParameterValueResolver<Runner>{
    void walk(){
        System.out.println("ice road");
    }
}
