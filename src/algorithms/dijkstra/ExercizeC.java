package algorithms.dijkstra;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

public class ExercizeC {
    private static final String START_POINT = "start";
    private static final Map<String, Map<String, Integer>> graph =
            Map.of("start", Map.of("a", 6, "b", 2, "e", 7),
                    "a", Map.of("c", 5),
                    "b", Map.of("a", 3, "d", 4),
                    "e", Map.of("c", 2),
                    "c", Map.of("fin", 1),
                    "d", Map.of("fin", 2));

    public static void main(String[] args) {
        double infinity = Double.POSITIVE_INFINITY;

        Map<String, String> parents = getStartParent();

        var costs = getStartCosts();
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

    public static Map<String, Double> getStartCosts() {
        var startNeighbors = graph.get(START_POINT);
        var startCosts = new HashMap<String, Double>();
        for (var neighbor : startNeighbors.entrySet()) {
            startCosts.put(neighbor.getKey(), Double.valueOf(neighbor.getValue()));
        }
        return startCosts;
    }

    public static Map<String, String> getStartParent() {
        var neighbors = graph.get(START_POINT);
        var startChildren = new HashMap<String, String>();
        for (var neighbor : neighbors.entrySet()) {
            startChildren.put(neighbor.getKey(), START_POINT);
        }
        return startChildren;
    }

    public static Map.Entry<String, Double> getNode(Map<String, Double> costs) {
        return costs.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(IllegalArgumentException::new);
    }
}
