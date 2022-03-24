package algorithms.dijkstra;

import java.util.*;
import java.util.stream.Collectors;

public class TheMain {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph =
                Map.of("start", Map.of("a", 6, "b", 2),
                        "a", Map.of("fin", 1),
                        "b", Map.of("a", 3, "fin", 5));

        double infinity = Double.POSITIVE_INFINITY;
        Map<String, Double> costs = new HashMap<>();
        costs.put("a", 6.0);
        costs.put("b", 2.0);
        costs.put("fin", infinity);

        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);
        Map<String, Double> processed = new HashMap<>();
        Box<String, Double> node = Box.findLowestCostNode(costs);

        while (node != null) {
            var cost = costs.get(node.getKey());
            if (graph.get(node.getKey()) == null) {
                break;
            }
            var neighbors = graph.get(node.getKey());

            for (Map.Entry<String, Integer> n : neighbors.entrySet()) {

                var newCost = cost + neighbors.get(n.getKey());

                if (costs.get(n.getKey()) > newCost) {
                    costs.replace(n.getKey(), newCost);
                    parents.put(n.getKey(), node.getKey());
                    processed.put(node.getKey(), node.getValue());
                }
            }
            node = Box.findLowestCostNode(
                    costs.entrySet().stream()
                            .filter(z -> !processed.containsKey(z.getKey()))
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        }
        System.out.println(costs);
        System.out.println(parents);
    }
}

class Box<T, V> {
    private final T key;
    private final V value;

    public Box(T key, V value) {
        this.key = key;
        this.value = value;
    }

    public static Box findLowestCostNode(Map<String, Double> costs) {
        double min = costs.values().stream().mapToDouble(aDouble -> aDouble).min().orElseThrow(NoSuchElementException::new);
        var entrySet =
                costs.entrySet().stream()
                        .filter(z -> z.getValue() == min).findFirst().get();
        return new Box(entrySet.getKey(), entrySet.getValue());
    }

    public T getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
