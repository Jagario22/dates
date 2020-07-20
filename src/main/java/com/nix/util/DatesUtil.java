package com.nix.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toMap;

public class DatesUtil {
    public static Map<LocalDate, Set<LocalTime>> sortByDate(List<LocalDateTime> dates) {
        Map<LocalDate, Set<LocalTime>> result = dates.stream()
                .collect(Collectors.groupingBy(LocalDateTime::toLocalDate,
                        Collectors.mapping(LocalDateTime::toLocalTime, Collectors.toSet())));

        return result.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, HashMap::new));
    }

    public static Duration maxDuration(List<LocalDateTime> dates) {
        Duration y;
        Duration max;
        LocalDateTime current = dates.get(0);
        LocalDateTime next = dates.get(1);

        if (current.compareTo(next) > 0)
            max = Duration.between(next, current);
        else
            max = Duration.between(current, next);

        for (int i = 0; i < dates.size(); i++) {
            for (int j = i + 1; j < dates.size(); j++) {
                if (i != j) {
                    current = dates.get(i);
                    next = dates.get(j);

                    if (current.compareTo(next) > 0)
                        y = Duration.between(next, current);
                    else
                        y = Duration.between(current, next);

                    if (max.compareTo(y) < 0)
                        max = y;
                }

            }
        }
        return max;
    }
}
