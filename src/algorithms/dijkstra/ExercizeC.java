package algorithms.dijkstra;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class ExercizeC {
    private static final Map<String, Map<String, Integer>> graph =
            Map.of("start", Map.of("a", 6, "b", 2, "e", 7),
                    "a", Map.of("c", 5),
                    "b", Map.of("a", 3, "d", 4),
                    "e", Map.of("c", 2),
                    "c", Map.of("fin", 1),
                    "d", Map.of("fin", 3));

    public static void main(String[] args) {
        double infinity = Double.POSITIVE_INFINITY;
        Map<String, Double> costs = new HashMap<>();
        costs.put("a", 6.0);
        costs.put("b", 2.0);
        costs.put("e", 7.0);

        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("e", "start");

        Map<String, Double> processed = new HashMap<>();
        var node = getNode(costs);

        while (node != null) {
            var neighbors = graph.get(node.getKey());
            if (isNull(neighbors)) break;

            for (Map.Entry<String, Integer> neighbor : neighbors.entrySet()) {
                var newCost = node.getValue() + neighbor.getValue();
                var bool =
                        costs.entrySet().stream()
                                .noneMatch(cost -> cost.getKey().contains(neighbor.getKey()));
                if (bool) costs.put(neighbor.getKey(), infinity);

                if (newCost < costs.get(neighbor.getKey())) {
                    costs.replace(neighbor.getKey(), newCost);
                    parents.put(neighbor.getKey(), node.getKey());
                }
                processed.put(node.getKey(), node.getValue());
            }
            node = getNode(
                    costs.entrySet().stream()
                            .filter(n -> !processed.containsKey(n.getKey()))
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        }
        System.out.println("costs: " + costs);
        System.out.println("parents: " + parents);
    }

    public static Map.Entry<String, Double> getNode(Map<String, Double> costs) {
        return costs.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(IllegalArgumentException::new);
    }
}
