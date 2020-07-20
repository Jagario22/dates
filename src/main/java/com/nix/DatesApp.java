package com.nix;

import com.nix.util.DatesUtil;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class DatesApp {
    public static void main(String[] args) {
        List<LocalDateTime> dates = Arrays.asList(LocalDateTime.of(2000, 12, 22, 22, 12, 13),
                LocalDateTime.of(2000,12,22, 13,4, 34),
                LocalDateTime.of(2000,4, 15, 21, 16, 43),
                LocalDateTime.of(2000, 3, 12, 22, 3, 13));

        Map<LocalDate, Set<LocalTime>> result = DatesUtil.sortByDate(dates);
        System.out.println("1. Dates: " + dates.toString());
        System.out.println("HashMap: " + result.toString() + "\n");

        Duration duration = DatesUtil.maxDuration(dates);
        System.out.println("2. Dates: " + dates.toString());
        System.out.println("Duration: " + duration.getSeconds());

    }
}
