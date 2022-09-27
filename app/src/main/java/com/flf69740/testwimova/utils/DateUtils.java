package com.flf69740.testwimova.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateUtils {

    public DateUtils() {
    }

    public String getDateToString() {
        return new SimpleDateFormat("MM/dd/yyyy", Locale.FRANCE).format(Calendar.getInstance().getTime());
    }
}
