package com.payment.sample;

import com.payment.sample.datesorter.DateSorter;
import com.payment.sample.datesorter.DateSorterImpl;
import com.payment.sample.util.DateUtility;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class DateSorterImplTest {

    DateSorter dateSorter = new DateSorterImpl();
    private static final Set<LocalDate> UNSORTED_DATES = initLocalDates();
    private static final List<LocalDate> EXPECTED_SORTED_DATES = initExpectedOrder();
    private static final List<LocalDate> UNEXPECTED_SORTED_DATES = initUnExpectedOrder();

    @Test
    public void When_SortedLocalDates_Expect_ReturnOrderedLocalDates() {
        assertEquals(new ArrayList<>(dateSorter.sortDates(UNSORTED_DATES)), EXPECTED_SORTED_DATES);
    }

    @Test
    public void When_SortedLocalDates_UnExpect_ReturnUnOrderedLocalDates() {
        assertNotEquals(new ArrayList<>(dateSorter.sortDates(UNSORTED_DATES)), UNEXPECTED_SORTED_DATES);
    }

    @Test
    public void When_SortedLocalDatesIsNull_Expect_NotReturnNull() {
        assertNotNull(dateSorter.sortDates(null));
    }

    @Test
    public void When_SortedLocalDatesIsNull_Expect_ReturnEmptySet() {
        assertTrue(dateSorter.sortDates(null).isEmpty());
    }

    @Test
    public void When_SortedLocalDatesIsEmpty_Expect_ReturnEmptySet() {
        assertTrue(dateSorter.sortDates(Collections.emptySet()).isEmpty());
    }

    private static Set<LocalDate> initLocalDates() {
        return Stream.of(
                        DateUtility.parseStringToLocalDate("01/07/19"),
                        DateUtility.parseStringToLocalDate("02/01/19"),
                        DateUtility.parseStringToLocalDate("01/01/19"),
                        DateUtility.parseStringToLocalDate("03/05/19"))
                .collect(Collectors.toSet());
    }

    private static List<LocalDate> initExpectedOrder() {
        return Stream.of(
                        DateUtility.parseStringToLocalDate("01/01/19"),
                        DateUtility.parseStringToLocalDate("02/01/19"),
                        DateUtility.parseStringToLocalDate("01/07/19"),
                        DateUtility.parseStringToLocalDate("03/05/19"))
                .collect(Collectors.toList());
    }

    private static List<LocalDate> initUnExpectedOrder() {
        return Stream.of(
                        DateUtility.parseStringToLocalDate("02/01/19"),
                        DateUtility.parseStringToLocalDate("03/05/19"),
                        DateUtility.parseStringToLocalDate("01/01/19"),
                        DateUtility.parseStringToLocalDate("01/07/19"))
                .collect(Collectors.toList());
    }
}
