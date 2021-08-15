package algorithms.dijkstra;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class TheMain {
    public static void main(String[] args) {
        Map<String, List<Map<String, Integer>>> graph =
                Map.of("start", Arrays.asList(Map.of("a", 6, "b", 2)),
                        "a", Arrays.asList(Map.of("fin", 1)),
                        "b", Arrays.asList(Map.of("a", 3, "fin", 5)));
        double infinity = Double.POSITIVE_INFINITY;
        Map<String, Double> costs = Map.of("a", 6.0, "b", 2.0, "fin", infinity);
        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin",null);
        List<String> processed = new ArrayList<>();
        var node=findLowestCostNode(costs);
        while(node !=null){
//            var cost=costs.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,e->e.getKey().equals(node.g)))
//       var neighbors=graph.co
        }
        System.out.println();
    }

    public static Map<String, Double> findLowestCostNode(Map<String, Double> costs) {
        double min = costs.entrySet().stream().mapToDouble(x -> x.getValue()).min().orElseThrow(NoSuchElementException::new);
        var entrySet = costs.entrySet().stream().filter(z -> z.getValue() == min).findFirst().get();
        return Map.of(entrySet.getKey(), entrySet.getValue());
    }
}
