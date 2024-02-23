package com.eremin.antispamplugin;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {
    private String logFilePath;

    public LoggerUtil(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public void log(String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = currentTime.format(formatter);

        try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, true))) {
            writer.println("[" + formattedTime + "] " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}