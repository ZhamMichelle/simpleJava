package algorithms.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CalculatedWeight {
    private List<Integer> weight;
    private Map<Integer,ArrayList<ArrayList<String>>> name;

    public CalculatedWeight(List<Integer> weight, Map<Integer,ArrayList<ArrayList<String>>> name) {
        this.weight = weight;
        this.name = name;
    }

    public List<Integer> getWeight() {
        return weight;
    }

    public Map<Integer,ArrayList<ArrayList<String>>> getName() {
        return name;
    }


    @Override
    public String toString() {
        return "SubResult{" +
                "weight=" + weight +
                ", name=" + name +
                '}';
    }
}
