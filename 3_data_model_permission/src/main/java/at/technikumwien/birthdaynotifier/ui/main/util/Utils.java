package at.technikumwien.birthdaynotifier.ui.main.util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bellacraine on 06.05.2017.
 */

public class Utils {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat CARD_DATE_FORMAT = new SimpleDateFormat("dd. MMM\nyyyy");

    public static Date parseDate (String date) {
        try {
            return DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            Log.e("Utils", "Could not parse date-string");
            return null;
        }
    }

    public static String formatBirthday (Date date) {
        return CARD_DATE_FORMAT.format(date);
    }

}
