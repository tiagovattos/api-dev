package br.edu.fema.apidev.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeFormatter {
    public static String dateToString(LocalDateTime data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return data.format(formatter);
    }
}
