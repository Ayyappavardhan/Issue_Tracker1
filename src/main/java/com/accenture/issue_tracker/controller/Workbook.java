package com.accenture.issue_tracker.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Workbook {

    public static void main(String[] args) {
        String date = "2023-07-01";

        LocalDate now = LocalDate.now();
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1);
        LocalDate parse1 = LocalDate.parse(date);
        System.out.println(parse1);
        LocalDateTime parse = parse1.atStartOfDay();
        System.out.println(parse);
    }
}
