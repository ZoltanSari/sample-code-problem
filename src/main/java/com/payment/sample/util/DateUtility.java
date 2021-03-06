package com.payment.sample.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateUtility {

    public static LocalDate parseStringToLocalDate(String date) {
        return date != null && !date.isEmpty() ? LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yy")) : null;
    }

    public static String formatLocalDateToString(LocalDate date) {
        return date != null ? date.format(DateTimeFormatter.ofPattern("dd/MM/yy")) : null;
    }
}
