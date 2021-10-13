import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
//        Date curentDate=new Date();
//        LocalDateTime localDateTime=LocalDateTime.ofInstant(curentDate.toInstant(), ZoneId.systemDefault());
//        System.out.println(localDateTime);
//        System.out.println(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()));
//
//        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate ld = LocalDate.parse("2017-03-13", DATEFORMATTER);
//        LocalDateTime ldt = LocalDateTime.of(ld, LocalDateTime.now().toLocalTime());
//        System.out.println(ldt);
//
//        System.out.println(LocalDate.parse("2017-10-18", DateTimeFormatter.ofPattern("yyyy-MM-dd"))
//                .atStartOfDay().atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));
//
//        String formatted = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ldt);
//        System.out.println(formatted);
//
//        DateTimeFormatter DATEFORMATTER2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDateTime ldt2 = LocalDateTime.parse("2021-09-17T17:50:57.193", DATEFORMATTER);

//        List<Integer> test = List.of(5, 7, 8, 9);
//        //System.out.println(test.stream().filter(f -> !f.equals(null)).collect(Collectors.toList()));
//        test.stream().map(z -> {
//            z = z + 5;
//            System.out.println(z);
//            return z;
//        });
//        System.out.println(test.stream().map(z -> {
//            z = z + 5;
//            return z;
//        }).collect(Collectors.toList()));
//

        var zero = List.of("smth", "sdas");
        var first = List.of();
        var second = Optional.ofNullable(first).orElse(Collections.emptyList()).stream()
                .filter(z -> !z.equals(null))
                .collect(Collectors.toList());
//        System.out.println(second);

        var third = Stream.ofNullable(zero)
                .flatMap(Collection::stream)
                .filter(z -> !z.equals(null))
                .collect(Collectors.toList());
//        System.out.println(third);

        var test= zero.stream().reduce((f,s)->s).orElseThrow();
        System.out.println(test);
    }


}
