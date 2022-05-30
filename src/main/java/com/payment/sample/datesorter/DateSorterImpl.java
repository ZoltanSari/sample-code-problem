package com.payment.sample.datesorter;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateSorterImpl implements DateSorter {

    @Override
    public SortedSet<LocalDate> sortDates(Set<LocalDate> unsortedDates) {
        TreeSet<LocalDate> sortedDates = new TreeSet<>(this::compareLocalDates);

        unsortedDates.stream()
                .filter(this::isMonthContainsR)
                .sorted()
                .forEach(sortedDates::add);

        unsortedDates.stream()
                .filter(date -> !isMonthContainsR(date))
                .sorted(Comparator.reverseOrder())
                .forEach(sortedDates::add);

        return sortedDates;
    }

    private boolean isMonthContainsR(LocalDate date) {
        return getLocalDateMonth(date).contains("r");
    }

    private int compareLocalDates(LocalDate date1, LocalDate date2) {
         return !isMonthContainsR(date1) && date1.getMonthValue() <= date2.getMonthValue() ? date2.compareTo(date1) : date1.compareTo(date2);
    }

    private String getLocalDateMonth(LocalDate date) {
        return date.getMonth().getDisplayName(TextStyle.FULL, Locale.US);
    }
}
