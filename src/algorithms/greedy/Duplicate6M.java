package algorithms.greedy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Duplicate6M {

    public static void main(String[] args) {
        Set<String> states_needed = new HashSet<>();
        states_needed.add("mt");
        states_needed.add("wa");
        states_needed.add("or");
        states_needed.add("id");
        states_needed.add("nv");
        states_needed.add("ut");
        states_needed.add("ca");
        states_needed.add("az");

        Map<String, Set<String>> stations = Map.of(
                "kone", Set.of("id", "nv", "ut"),
                "ktwo", Set.of("wa", "id", "mt"),
                "kthree", Set.of("or", "nv", "ca"),
                "kfour", Set.of("nv", "ut"),
                "kfive", Set.of("ca", "az")
        );

        Set<String> states_final = new HashSet<>();

        while (!states_needed.isEmpty()) {
            Set<String> states_covered = new HashSet<>();
            for (Map.Entry<String, Set<String>> station : stations.entrySet()) {
                var covered =
                        Stream.concat(station.getValue().stream(), states_covered.stream())
                                .collect(Collectors.toSet());
                if (covered.size() > states_covered.size()) {
                    states_covered.addAll(covered);
                    states_final.add(station.getKey());
                    states_needed.removeAll(station.getValue());
                }
            }
        }
        System.out.println("final stations: " + states_final);
    }
}
