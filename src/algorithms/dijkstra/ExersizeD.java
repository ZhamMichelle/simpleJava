package algorithms.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class ExersizeD {
    private static final String START_POINT = "start";
    private static final Map<String, Map<String, Integer>> graph =
            Map.of("start", Map.of("a", 6, "b", 2, "e", 7),
                    "a", Map.of("c", 5),
                    "b", Map.of("a", 3, "d", 4),
                    "e", Map.of("c", 2),
                    "c", Map.of("fin", 1),
                    "d", Map.of("fin", 12));

    public static void main(String[] args) {
        var infinity = Double.POSITIVE_INFINITY;
        var costs = getStartedCosts();
        var parents = getParent();
        var minNode = getMinNode(costs);
        var processed = new ArrayList<String>();
        while (minNode != null) {
            var neighbors = graph.get(minNode.getKey());
            if (isNull(neighbors)) break;
            for (var neighbor : neighbors.entrySet()) {
                var isExist = costs.entrySet().stream()
                        .noneMatch(cost -> cost.getKey().contains(neighbor.getKey()));
                if (isExist) costs.put(neighbor.getKey(), infinity);
                var newCost = neighbor.getValue() + minNode.getValue();
                if (newCost < costs.get(neighbor.getKey())) {
                    costs.replace(neighbor.getKey(), newCost);
                    parents.put(neighbor.getKey(), minNode.getKey());
                }
                processed.add(minNode.getKey());
            }
            minNode = getMinNode(costs.entrySet().stream()
                    .filter(n -> !processed.contains(n.getKey()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        }
        System.out.println("costs: " + costs);
        System.out.println("parents: " + parents);
    }

    public static Map<String, Double> getStartedCosts() {
        var startNeighbors = graph.get(START_POINT);
        var startCosts = new HashMap<String, Double>();
        for (var neighbor : startNeighbors.entrySet()) {
            startCosts.put(neighbor.getKey(), neighbor.getValue().doubleValue());
        }
        return startCosts;
    }

    public static Map<String, String> getParent() {
        var startNeighbors = graph.get(START_POINT);
        var startChildren = new HashMap<String, String>();
        for (var neighbor : startNeighbors.entrySet()) {
            startChildren.put(neighbor.getKey(), START_POINT);
        }
        return startChildren;
    }

    public static Map.Entry<String, Double> getMinNode(Map<String, Double> costs) {
        return costs.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(IllegalArgumentException::new);
    }
}
