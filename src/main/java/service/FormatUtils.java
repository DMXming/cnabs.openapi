package service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtils {
    public static String dateToYMD(Date date) {
        if (date != null)
            return new SimpleDateFormat("yyyy-MM-dd").format(date);
        else
            return "";
    }

    public static Date strToDate(String datestr) {
        if (datestr != null && !datestr.isEmpty()) {
            return new SimpleDateFormat("yyyy-MM-dd").parse(datestr, new ParsePosition(0));
        }
        return null;
    }
}
