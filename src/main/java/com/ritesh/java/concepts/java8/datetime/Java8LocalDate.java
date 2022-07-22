package com.ritesh.java.concepts.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class Java8LocalDate
{
    public static void main(String[] args)
    {
        testDate();
    }

    private static void testDate()
    {
        Date testDate = null;
        LocalDate testLocalDate = null;
        LocalDateTime testLocalDateTime = null;
        String testLocalDateStr = null;

        // Old Date object | Before Java 8
        testDate = new Date();
        System.out.println(testDate);

        // New LocalDate Object | From Java 8 onwards
        testLocalDate = LocalDate.now();
        System.out.println(testLocalDate);

        testLocalDate = LocalDate.parse("2022-03-29");
        System.out.println(testLocalDate);

        testLocalDateStr = testLocalDate.format(DateTimeFormatter.ISO_DATE);
        System.out.println(testLocalDateStr);

        testLocalDateTime = testLocalDate.atTime(01, 01, 00);
        System.out.println(testLocalDateTime);

        testLocalDateTime = LocalDateTime.now();
        System.out.println(testLocalDateTime);

        testLocalDateTime = LocalDateTime.parse("2022-01-01T01:01:59.123456789");
        System.out.println(testLocalDateTime);
    }
}