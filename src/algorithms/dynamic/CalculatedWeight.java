package algorithms.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CalculatedWeight {
    private List<Integer> weight;
    private Map<Integer,ArrayList<ArrayList<String>>> names;

    public CalculatedWeight(List<Integer> weight, Map<Integer,ArrayList<ArrayList<String>>> names) {
        this.weight = weight;
        this.names = names;
    }

    public List<Integer> getWeight() {
        return weight;
    }

    public Map<Integer,ArrayList<ArrayList<String>>> getNames() {
        return names;
    }


    @Override
    public String toString() {
        return "SubResult{" +
                "weight=" + weight +
                ", name=" + names +
                '}';
    }
}
