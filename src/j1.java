import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;


class j1 {

    public static void main(String[] args) {

        // Q11
        java.util.Date f = new java.util.Date();
        SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
        String date = f1.format(f);
        System.out.println(date);

        // LocalDateTime d = LocalDateTime.now();

        // DateTimeFormatter dat = DateTimeFormatter.ofPattern("dd/mm/yyyy mm:hh:ss");
        // String date1 = dat.format(d);
        // System.out.println(date1);

        // Q12
        LocalDate b = LocalDate.of(2021, 01, 01);
        LocalDate c = LocalDate.of(2021, 04, 01);

        long d = ChronoUnit.DAYS.between(b, c);
        System.out.println(d);

        // Month month = Month.JANUARY;
        // Year year = Year.of(2021);
        // LocalDate d = b.with(TemporalAdjusters.firstDayOfMonth());
        // System.out.println(d);

        // Month value = d.getMonth();

        // Q11
        while (c.isAfter(b)) {

            b = b.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
            System.out.println(b);
            // value = d.getMonth();
		}
        
        
        Locale locale=Locale.getDefault();
        
        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getCountry());
        
	}
    
    
    
    
    
}