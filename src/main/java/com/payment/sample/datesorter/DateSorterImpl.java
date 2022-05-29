package com.payment.sample.datesorter;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

public class DateSorterImpl implements DateSorter {

    @Override
    public SortedSet<LocalDate> sortDates(Set<LocalDate> unsortedDates) {
        TreeSet<LocalDate> sortedDates = new TreeSet<>((localDate1, localDate2) -> {
            String localDate1Month = localDate1.getMonth().getDisplayName(TextStyle.FULL, Locale.US);
            String localDate2Month = localDate2.getMonth().getDisplayName(TextStyle.FULL, Locale.US);

            if (localDate1Month.contains("r")) {
                return localDate1.compareTo(localDate2);
            }else if (localDate2Month.contains("r")) {
                return localDate2.compareTo(localDate1);
            } else {
                return localDate2.compareTo(localDate1);
            }
        });

        List<LocalDate> unsortedDatesArrayList = new ArrayList<>(unsortedDates);
        List<LocalDate> unsortedDatesArrayListWithR = new ArrayList<>();
        List<LocalDate> unsortedDatesArrayListWithoutR = new ArrayList<>();

        for (LocalDate date : unsortedDatesArrayList) {
            String month = date.getMonth().getDisplayName(TextStyle.FULL, Locale.US);
            if (month.contains("r")) {
                unsortedDatesArrayListWithR.add(date);
            } else {
                unsortedDatesArrayListWithoutR.add(date);
            }
        }

        unsortedDatesArrayListWithR.sort(Comparator.reverseOrder());
        unsortedDatesArrayListWithoutR.sort(Comparator.reverseOrder());

        unsortedDatesArrayList.clear();
        unsortedDatesArrayList.addAll(unsortedDatesArrayListWithR);
        unsortedDatesArrayList.addAll(unsortedDatesArrayListWithoutR);

        sortedDates.addAll(unsortedDatesArrayList);

        return sortedDates;
    }
}
