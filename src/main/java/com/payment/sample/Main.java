package com.payment.sample;

import com.payment.sample.datesorter.DateSorter;
import com.payment.sample.datesorter.DateSorterImpl;
import com.payment.sample.util.DateUtility;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        DateSorter dateSorter = new DateSorterImpl();
        Set<LocalDate> unsortedDates = initLocalDates();

        dateSorter.sortDates(unsortedDates)
                .stream().map(DateUtility::formatLocalDateToString)
                .forEach(System.out::println);
    }

    private static Set<LocalDate> initLocalDates() {
        return Stream.of(
                        DateUtility.parseStringToLocalDate("01/07/19"),
                        DateUtility.parseStringToLocalDate("02/01/19"),
                        DateUtility.parseStringToLocalDate("01/01/19"),
                        DateUtility.parseStringToLocalDate("03/05/19"))
                .collect(Collectors.toSet());
    }
}