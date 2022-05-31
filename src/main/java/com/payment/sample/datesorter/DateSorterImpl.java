package com.payment.sample.datesorter;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.commons.collections4.SetUtils.emptyIfNull;

public class DateSorterImpl implements DateSorter {

    @Override
    public SortedSet<LocalDate> sortDates(Set<LocalDate> unsortedDates) {
        SortedSet<LocalDate> sortedDates = new TreeSet<>(this::compareLocalDates);

        emptyIfNull(unsortedDates).stream()
                .flatMap(Stream::ofNullable)
                .filter(this::isMonthContainsR)
                .sorted()
                .forEach(sortedDates::add);

        emptyIfNull(unsortedDates).stream()
                .flatMap(Stream::ofNullable)
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
