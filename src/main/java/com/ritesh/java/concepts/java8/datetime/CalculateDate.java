package com.ritesh.java.concepts.java8.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CalculateDate
{
    public static void main(String[] args) {
        calculateRequiredDate();
    }

    private static void calculateRequiredDate()
    {
        LocalDate inputDate = LocalDate.parse("2023-05-21");
        int daysToAdd = 98;
        LocalDate outputDate = inputDate.plusDays(daysToAdd);
        System.out.println(outputDate);
    }

    private static void calculateDaysBetweenTwoDates()
    {
        LocalDateTime date1 = LocalDateTime.parse("2023-01-14T00:00:00.123456789");
        LocalDateTime date2 = LocalDateTime.parse("2023-05-21T00:00:00.123456789");
        System.out.println(Duration.between(date1, date2).toDays());
    }
}
