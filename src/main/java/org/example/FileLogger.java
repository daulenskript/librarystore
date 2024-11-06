package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private static final String LOG_FILE = "library_logs.txt";

    public static void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            LocalDateTime now = LocalDateTime.now();
            String timestamp = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            writer.write(timestamp + ": " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
