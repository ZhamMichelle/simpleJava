package algorithms.greedy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExersizeA {
    public static void main(String[] args) {
        Set<String> allStates = new HashSet<>();
        allStates.add("mt");
        allStates.add("wa");
        allStates.add("or");
        allStates.add("id");
        allStates.add("nv");
        allStates.add("ut");
        allStates.add("ca");
        allStates.add("az");


        Map<String, Set<String>> stations = Map.of(
                "kone", Set.of("id", "nv", "ut"),
                "ktwo", Set.of("wa", "id", "mt"),
                "kthree", Set.of("or", "nv", "ca"),
                "kfour", Set.of("nv", "ut"),
                "kfive", Set.of("ca", "az")
        );

        var finalStates = new HashSet<String>();

        while (!allStates.isEmpty()) {
            var coveredStates = new HashSet<String>();
            for (var station : stations.entrySet()) {
                var helper =
                        Stream.concat(coveredStates.stream(), station.getValue().stream())
                                .collect(Collectors.toSet());
                if (helper.size() > coveredStates.size()) {
                    finalStates.add(station.getKey());
                    coveredStates.addAll(helper);
                }
            }
            coveredStates.forEach(allStates::remove);
            System.out.println("finalStates: " + finalStates);
        }
    }
}
