package com.alegerd.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CurrentWeekDayProvider {

    public static String getCurrentWeekDay(){
        SimpleDateFormat format = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        return format.format(new Date());
    }
}