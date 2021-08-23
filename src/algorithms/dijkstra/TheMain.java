package algorithms.dijkstra;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class TheMain {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph =
                Map.of("start", Map.of("a", 6, "b", 2),
                        "a", Map.of("fin", 1),
                        "b", Map.of("a", 3, "fin", 5));
        double infinity = Double.POSITIVE_INFINITY;
        Map<String, Double> costs = Map.of("a", 6.0, "b", 2.0, "fin", infinity);
        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        //parents.put("c", "start");
        //lallalala
        //blablablabla
        parents.put("b", "start");
        parents.put("fin",null);
        Map<String,Double> processed = new HashMap<>();
        Map<String,Double> node=findLowestCostNode(costs);
        while(node !=null){
            var cost=costs.get(node);
       var neighbors=graph.get(node);
            for (Map.Entry<String,Integer> n:neighbors.entrySet()) {
                var newCost=cost+neighbors.get(n);
                if(costs.get(n)>newCost){
                   costs.put(n.getKey(),newCost);
                   parents.put(n.getKey(),node.entrySet().iterator().next().getKey());
                   processed.put(node.entrySet().iterator().next().getKey(),node.entrySet().iterator().next().getValue());
                }
            }
        }
        System.out.println();
    }

    public static Map<String, Double> findLowestCostNode(Map<String, Double> costs) {
        double min = costs.entrySet().stream().mapToDouble(x -> x.getValue()).min().orElseThrow(NoSuchElementException::new);
        var entrySet = costs.entrySet().stream().filter(z -> z.getValue() == min).findFirst().get();
        return Map.of(entrySet.getKey(), entrySet.getValue());
    }
}
