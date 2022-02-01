import patterns.adapter.*;

import java.lang.reflect.ParameterizedType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForQuickTest {
    private static Object GoldRoad;

    public static void main(String[] args) throws ParseException {
        var a = Map.of("a", 2);
        var b = Map.of("a", 3,
                "b", 1);
        var templates = Stream.concat(
                a.entrySet().stream(),
                b.entrySet().stream()
        ).collect(HashMap::new, (m, v) -> m.put(v.getKey(), v.getValue()), HashMap::putAll);
        System.out.println(templates);

        var templates2 = Stream.concat(
                a.entrySet().stream(),
                b.entrySet().stream());

        System.out.println("dshop".replace("shop", ""));
        System.out.println("dshor".replace("shop", ""));


//        var test = GoldRoad.class.getSuperclass();
//        System.out.println(test);
//        var test2 = (ParameterizedType)test.getClass().getGenericSuperclass();
//        System.out.println(test2);
//
//        var test1 = IceRoad.class.getGenericSuperclass();
//        System.out.println(test1);

        //System.out.println(GoldRoad.getClass().getEnclosingClass().getName());

        final DayOfWeek firstDayOfWeek = WeekFields.of(Locale.GERMAN).getFirstDayOfWeek();
        System.out.println(firstDayOfWeek.getValue());
        final DayOfWeek firstDayOfWeek1 = WeekFields.of(Locale.FRANCE).getFirstDayOfWeek();
        System.out.println(firstDayOfWeek1.getValue());

//        final YearMonth firstMonthOfYear = YearF
        Locale locale2 = Locale.FRANCE;
        Calendar cal3 = Calendar.getInstance(locale2);
        System.out.println(cal3.get(Calendar.DAY_OF_MONTH));

        Date date=new Date();
        System.out.println(cal3.get(Calendar.DAY_OF_WEEK));
        System.out.println(cal3.get(Calendar.DAY_OF_YEAR));

//        String pattern = "MM-d-yyyy";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String date1 = simpleDateFormat.format(cal3.add(Calendar.Date,5));
//        System.out.println(date1);

//        String dt = "2008-01-09";  // Start date
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-d");
//        Calendar c = Calendar.getInstance();
//        c.setTime(sdf.parse(dt));
//        c.add(Calendar.DATE, 0);  // number of days to add
//        dt = sdf.format(c.getTime());
//        System.out.println(dt);
//
//        final var fmt =
//                DateTimeFormatter.ofPattern("yyyy-MM");
//        System.out.println(LocalDate.parse("2018-12-27", fmt));
        var localDate=LocalDate.now().plusDays(1);
        System.out.println(LocalDate.now().isBefore(localDate) && LocalDate.now().plusDays(2).isAfter(localDate));

        Calendar currentDate=new GregorianCalendar();
        System.out.println(currentDate);
        String dayOfWeek = currentDate.getDisplayName( Calendar.DAY_OF_WEEK ,Calendar.LONG, Locale.getDefault());
        System.out.println(dayOfWeek);
        final Calendar calendar =
                GregorianCalendar.getInstance();
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(TimeUnit.MINUTES.toMillis(Integer.valueOf(calendar.get(Calendar.HOUR_OF_DAY)).byteValue()));
        System.out.println(Integer.valueOf(calendar.get(Calendar.MINUTE)).byteValue());

        System.out.println(test() instanceof GoldRoad);
    }

    public static IceRoad test(){
        return new IceRoad();
    }
}
