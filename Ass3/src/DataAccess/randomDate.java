package DataAccess;
import java.util.GregorianCalendar;



public class randomDate {

    public static String getDate(int start, int end) {

        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(start, end);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        String date = gc.get(gc.DAY_OF_MONTH) + "." + (gc.get(gc.MONTH) + 1) +"." + (gc.get(gc.YEAR));
        return date;

    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}

