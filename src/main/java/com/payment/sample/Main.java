package com.payment.sample;

import com.payment.sample.datesorter.DateSorter;
import com.payment.sample.datesorter.DateSorterImpl;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        DateSorter dateSorter = new DateSorterImpl();
        Set<LocalDate> unsortedDates = Stream.of(LocalDate.of(2019, 7, 1),
                        LocalDate.of(2019, 1, 2),
                        LocalDate.of(2019, 12, 2),
                        LocalDate.of(2019, 10, 2),
                        LocalDate.of(2019, 9, 2),
                        LocalDate.of(2019, 2, 2),
                        LocalDate.of(2019, 7, 12),
                        LocalDate.of(2019, 6, 4),
                        LocalDate.of(2019, 8, 2),
                        LocalDate.of(2019, 1, 1),
                        LocalDate.of(2019, 5, 3))
                .collect(Collectors.toSet());

        dateSorter.sortDates(unsortedDates).forEach(System.out::println);
    }
}