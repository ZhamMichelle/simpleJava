import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date curentDate=new Date();
        LocalDateTime localDateTime=LocalDateTime.ofInstant(curentDate.toInstant(), ZoneId.systemDefault());
        System.out.println(localDateTime);
        System.out.println(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()));

        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ld = LocalDate.parse("2017-03-13", DATEFORMATTER);
        LocalDateTime ldt = LocalDateTime.of(ld, LocalDateTime.now().toLocalTime());
        System.out.println(ldt);

        System.out.println(LocalDate.parse("2017-10-18", DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                .atStartOfDay().atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));

        String formatted = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ldt);
        System.out.println(formatted);

        DateTimeFormatter DATEFORMATTER2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime ldt2 = LocalDateTime.parse("2021-09-17T17:50:57.193", DATEFORMATTER);
    }
}
