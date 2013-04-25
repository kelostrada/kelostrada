package LamaczHasel;

/**
 * @author bartosz.kalinowski
 */

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    @Override
    public String toString() {
        return twoDigitNumber(year) + twoDigitNumber(month) + twoDigitNumber(day);
    }
    
    private String twoDigitNumber(int number) {
        String result = String.valueOf(number);
        if (number > 99) {
            result = result.substring(result.length()-2);
        } else if (number < 10) {
            result = 0 + result;
        }
        
        return result;
    }
    
}
