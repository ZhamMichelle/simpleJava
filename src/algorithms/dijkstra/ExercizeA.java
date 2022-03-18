package algorithms.dijkstra;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ExercizeA {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph = Map.of(
                "start", Map.of("a", 5,
                        "b", 2),
                "a", Map.of("c", 4,
                        "d", 2),
                "b", Map.of("a", 8,
                        "d", 7),
                "c", Map.of("fin", 3,
                        "d", 6),
                "d", Map.of("fin", 1)
        );
        double infinity = Double.POSITIVE_INFINITY;
        Map<String, Double> costs = new HashMap<>();
        costs.put("a", 5.0);
        costs.put("b", 2.0);
        costs.put("c", infinity);
        costs.put("d", infinity);
        costs.put("fin", infinity);


        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("c", null);
        parents.put("d", null);
        parents.put("fin", null);

        List<String> proceed = new ArrayList<>();

        TakeMinValue<String, Double> node = TakeMinValue.minValue(costs);
        while (node != null) {
            var cost = costs.get(node.getKey());
            if (graph.get(node.getKey()) == null) {
                break;
            }
            var neighbors = graph.get(node.getKey());
            System.out.println("neighbors: " + neighbors);
            for (Map.Entry<String, Integer> item : neighbors.entrySet()) {
                var newCost = cost + item.getValue();
                System.out.println("newCost: " + newCost);
                if (newCost < costs.get(item.getKey())) {
                    costs.put(item.getKey(), newCost);
                    parents.put(item.getKey(), node.getKey());
                    proceed.add(node.getKey());
                }
            }
            System.out.println("proceed: " + proceed);
            node = TakeMinValue.minValue(costs.entrySet().stream()
                    .filter(z -> !proceed.contains(z.getKey())).collect(Collectors.toMap(
                            Map.Entry::getKey, Map.Entry::getValue
                    )));
        }
        System.out.println(costs);


        Calendar eveningDate = Calendar.getInstance();
        eveningDate.setTime(new Date());
        System.out.println(eveningDate.getTime().getHours());


    }

    public Map<String, Double> getMinValue(Map<String, Double> costs) {
        System.out.println("min costs: " + costs);
        return costs.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue))
                .stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}

class TakeMinValue<T, V> {
    private T key;
    private V value;

    public TakeMinValue(T key, V value) {
        this.key = key;
        this.value = value;
    }

    public static TakeMinValue minValue(Map<String, Double> costs) {
        var min = costs.entrySet().stream().mapToDouble(z -> z.getValue()).min();
        var min2 = costs.entrySet().stream()
                .min(Comparator.comparing(Map.Entry::getValue)).stream().collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue));
        var min1 = costs.entrySet().stream()
                .min(Comparator.comparing(Map.Entry::getValue)).get().getKey();
        System.out.println(new TakeMinValue(min1, costs.get(min1)).key);
        return new TakeMinValue(min1, costs.get(min1));
    }

    public T getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
