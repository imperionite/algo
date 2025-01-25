package com.imperionite.algo.utils;

// define DateTimeFormatter as a public static variable within utility class. 
// This will allow to reuse the formatter throughout the application.

import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

}
