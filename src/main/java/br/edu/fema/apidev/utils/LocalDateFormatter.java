package br.edu.fema.apidev.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateFormatter {

    public static LocalDate toLocalDate(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatter);
    }

    public static String dateToString(LocalDate data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }
}
