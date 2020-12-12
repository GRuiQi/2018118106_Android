package com.example.easy_note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtil {
    public static String getTime(){

        TimeZone time = TimeZone.getTimeZone("ETC/GMT-8");
        TimeZone.setDefault(time);
        SimpleDateFormat format = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss"
        );
        Date curDate = new Date();
        String str = format.format(curDate);
        return str;
    }
}
