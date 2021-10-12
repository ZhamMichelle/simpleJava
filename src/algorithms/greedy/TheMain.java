package algorithms.greedy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TheMain {
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
        Set<String> final_stations = new HashSet<>();

         while (!states_needed.isEmpty()) {
        String best_station = null;
        Set<String> states_covered = new HashSet<>();
        for (Map.Entry<String, Set<String>> station : stations.entrySet()) {
            var covered = Stream.concat(states_covered.stream(), station.getValue().stream())
                    .collect(Collectors.toSet());
            if (covered.size() > states_covered.size()) {
                best_station = station.getKey();
                final_stations.add(best_station);
                states_covered = covered;
            }
        }
        System.out.println("states_covered: " + states_covered);
        states_needed.removeAll(states_covered);
        System.out.println("states_needed: " + states_needed);
         }
        System.out.println("final_stations: "+final_stations);
    }
}
