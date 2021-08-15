package algorithms.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TheMain {
    public static void main(String[] args) {
        String[] arr = new String[]{"e", "j", "g", "g"};
        Stream<String> stream = Arrays.stream(arr);
        System.out.println(stream.distinct().count());
        List<String> list = Arrays.asList("h", "p", "h");

        boolean bool = list.stream().anyMatch(element -> element.contains("p"));
        System.out.println(bool);

        Stream<String> stream1 = list.stream().filter(element -> element.contains("h"));
        System.out.println(stream1.distinct().count());

        List<String[]> arr2 = Arrays.asList(new String[]{"f", "fa"}, new String[]{"es", "gfd"}, new String[]{"dsfd", "fsd"});
        Stream<Integer> stream2 = arr2.stream().map(b -> b.length);
        System.out.println("stream2: " + stream2.collect(Collectors.toList()));

        List<Detail> details = new ArrayList<>();
        details.add(new Detail());
        Stream<String> stream3 = details.stream().flatMap(b -> b.getParts().stream()).filter(b -> b.contains("e"));
        System.out.println("stream3: " + stream3.collect(Collectors.toList()));
        Stream<List<String>> stream4 = details.stream().map(Detail::getParts).filter(b -> b.contains("re"));
        System.out.println("stream4: " + stream4.collect(Collectors.toList()));

        List<Integer> integers = Arrays.asList(10, 1, 1,8,15,10);
        Integer reduced = integers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("reduced: " + reduced);

        List<String> arr3 = Arrays.asList("re", "sd", "rew");
        Optional<String> opt = arr3.stream().findAny();
        System.out.println("opt: " + opt.get());
        List<String> arr4 = new ArrayList<>();
        Optional<String> opt1 = arr4.stream().findAny();

        System.out.println(opt1.isPresent());

    }
}

class Detail {
    private List<String> parts = Arrays.asList("re", "sd", "rew");

    public List<String> getParts() {
        return parts;
    }
}
