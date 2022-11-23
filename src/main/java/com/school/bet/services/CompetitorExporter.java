package com.school.bet.services;

import java.util.List;

import com.school.bet.entities.Competitor;

public class CompetitorExporter {
    ExporterService exporter;

    public CompetitorExporter() {
        try {
            this.exporter = new ExporterService(
                    "C:\\Users\\giova\\Dev\\topicos-contemporaneos-computacao\\competitors.txt");

        } catch (Exception e) {
            System.out.println("[ERROR] - EXPORT CREATION");
            // TODO: handle exception
        }
    }

    public void execute(List<Competitor> competitors) {
        try {
            String content = "name, registration, performance, standard\n";

            for (Competitor competitor : competitors) {
                content = content + competitor.toCSV() + "\n";
            }

            this.exporter.execute(content);
        } catch (Exception e) {
            System.out.println("[ERROR] - EXPORT EXECUTE");
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
    }
}
