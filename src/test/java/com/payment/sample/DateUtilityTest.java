package com.payment.sample;

import com.payment.sample.util.DateUtility;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.junit.Assert.*;

public class DateUtilityTest {

    private static final LocalDate DUMMY_LOCAL_DATE = LocalDate.of(2000, 12, 31);
    private static final String CORRECT_STRING_DATE_FORMAT = "31/12/00";
    private static final String INCORRECT_STRING_DATE_FORMAT = "31-12-20";

    @Test
    public void When_ParseStringToDate_Expect_ReturnRightFormat() {
        assertEquals(DateUtility.parseStringToLocalDate(CORRECT_STRING_DATE_FORMAT),  DUMMY_LOCAL_DATE);
    }

    @Test(expected = DateTimeParseException.class)
    public void When_ParseIncorrectStringToDate_Expect_ThrowDateTimeParseException() {
        assertNotEquals(DateUtility.parseStringToLocalDate(INCORRECT_STRING_DATE_FORMAT),  DUMMY_LOCAL_DATE);
    }

    @Test
    public void When_FormatLocalDateToString_Expect_ReturnRightFormat() {
        assertEquals(DateUtility.formatLocalDateToString(DUMMY_LOCAL_DATE), CORRECT_STRING_DATE_FORMAT);
    }

    @Test
    public void When_FormatIncorrectLocalDateToString_UnExpect_ReturnRightFormat() {
        assertNotEquals(DateUtility.formatLocalDateToString(DUMMY_LOCAL_DATE), INCORRECT_STRING_DATE_FORMAT);
    }

    @Test
    public void When_LocalDateIsNull_Expect_ReturnNull() {
        assertNull(DateUtility.formatLocalDateToString(null));
    }

    @Test
    public void When_StringDateIsNull_Expect_ReturnNull() {
        assertNull(DateUtility.parseStringToLocalDate(null));
    }

    @Test
    public void When_StringDateIsEmpty_Expect_ReturnNull() {
        assertNull(DateUtility.parseStringToLocalDate(null));
    }
}
