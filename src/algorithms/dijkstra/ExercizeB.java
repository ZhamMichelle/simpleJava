package algorithms.dijkstra;

import java.util.*;
import java.util.stream.Collectors;

public class ExercizeB {
    final static Map<String, Map<String, Integer>> graph = Map.of(
            "start", Map.of("a", 10),
            "a", Map.of("b", 20),
            "b", Map.of("c", 1,
                    "fin", 30),
            "c", Map.of("a", 1)
    );

    final static Double infinity = Double.POSITIVE_INFINITY;


    public static void main(String[] args) {
        Map<String, Double> costs = new HashMap<>();
        costs.put("a", 10.0);
        costs.put("b", infinity);
        costs.put("c", infinity);
        costs.put("fin", infinity);

        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", null);
        parents.put("c", null);
        parents.put("fin", null);
        List<String> proceed = new ArrayList<>();
        var node = MinValue.min(costs);
        while (node != null) {
            if(graph.get(node.getKey())==null){
                break;
            }
            var neighbors = graph.get(node.getKey());
            for (Map.Entry<String, Integer> k : neighbors.entrySet()) {
                System.out.println(costs);
                var newCost = k.getValue() + node.getValue();
                System.out.println("node: "+node.getKey());
                System.out.println("newcost: "+newCost);
                System.out.println("test: "+k.getKey());
                if (newCost<costs.get(k.getKey())) {
                    costs.replace(k.getKey(), newCost);
                    proceed.add(node.getKey());
                }else{
                    proceed.add(node.getKey());
                }
            }
            System.out.println("proceed: "+proceed);
            node=MinValue.min(costs.entrySet().stream().filter(z-> !proceed.contains(z.getKey()))
                    .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue)));
        }
    }

    public static Map<String, Double> getMinValue(Map<String, Double> costs) {
        return costs.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue)).stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}

class MinValue {
    private String key;
    private Double value;

    public MinValue(String key, Double value) {
        this.key = key;
        this.value = value;
    }

    public static MinValue min(Map<String, Double> costs) {
        System.out.println("costs: "+costs);
        var minimum = costs.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue)).get();
        System.out.println("fin: "+minimum);
        return new MinValue(minimum.getKey(), minimum.getValue());
    }

    public String getKey() {
        return key;
    }

    public Double getValue() {
        return value;
    }
}
