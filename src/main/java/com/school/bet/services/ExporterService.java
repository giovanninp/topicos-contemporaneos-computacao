package com.school.bet.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExporterService {
    BufferedWriter writer;
    String filePath;

    public ExporterService(String filePath) throws IOException {
        this.writer = new BufferedWriter(new FileWriter(filePath));
    }

    public void execute(String content) throws IOException {
        if (this.writer == null) {
            this.writer = new BufferedWriter(new FileWriter(filePath));
        }
        this.writer.write(content);
        this.writer.close();
    }
}
