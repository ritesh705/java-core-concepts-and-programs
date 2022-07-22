package com.ritesh.java.concepts.java8.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        LocalTime testLocalTime = null;
        String testLocalDateStr = null;
        String testLocalTimeStr = null;
        String testLocalDateTimeStr = null;

        // Old Date object | Before Java 8
        testDate = new Date();
        System.out.println(testDate);

        // New LocalDate Object | From Java 8 onwards
        testLocalDate = LocalDate.now();
        System.out.println(testLocalDate);

        // Parsing String To LocalDate
        testLocalDate = LocalDate.parse("2022-03-29");
        System.out.println(testLocalDate);

        // Formatting LocalDate To String
        testLocalDateStr = testLocalDate.format(DateTimeFormatter.ISO_DATE);
        System.out.println(testLocalDateStr);

        // LocalTime Object | From Java 8 onwards
        testLocalTime = LocalTime.now();
        System.out.println(testLocalTime);

        // Parsing String To LocalTime
        testLocalTime = LocalTime.parse("01:01:01.123456789");
        System.out.println(testLocalTime);

        // Formatting LocalTime To String
        testLocalTimeStr = testLocalTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println(testLocalTimeStr);

        // Adding Time to LocalDate
        testLocalDateTime = testLocalDate.atTime(01, 01, 00);
        System.out.println(testLocalDateTime);

        // LocalDateTime Object | From Java 8 onwards
        testLocalDateTime = LocalDateTime.now();
        System.out.println(testLocalDateTime);

        // Parsing String To LocalDateTime
        testLocalDateTime = LocalDateTime.parse("2022-01-01T01:01:59.123456789");
        System.out.println(testLocalDateTime);

        // Formatting LocalDateTime To String
        testLocalDateTimeStr = testLocalDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(testLocalDateTimeStr);

        // Instant Object | From Java 8 onwards
        Instant testInstant = Instant.now();
        System.out.println(testInstant);
    }
}