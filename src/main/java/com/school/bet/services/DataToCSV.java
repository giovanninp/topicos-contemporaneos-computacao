package com.school.bet.services;

import com.school.bet.entities.Competitor;

public class DataToCSV {

    DatabaseConnector databaseConnector;
    ExporterService competitorExporter;
    String competitorContent = "id, name, registration, performance, standard\n";

    public DataToCSV(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
        try {
            this.competitorExporter = new ExporterService(
                    "C:\\Users\\giova\\Dev\\topicos-contemporaneos-computacao\\competitors.txt");
        } catch (Exception e) {
            System.out.format("\n[ERROR]:[DATA TO CSV]: %s\n", e.getMessage());
        }
    }

    private void competitors() {
        this.databaseConnector.query("SELECT * FROM competitor", (result) -> {
            try {
                Long id = result.getLong("id");
                String name = result.getString("name");
                Long registration = result.getLong("registration");
                Float performance = result.getFloat("performance");
                Float standard = result.getFloat("standard");

                Competitor competitor = new Competitor(registration, name, performance, standard);

                String row = "" + Long.toString(id) + competitor.toCSV() + "\n";

                this.competitorContent = competitorContent + row;
            } catch (Exception e) {
                // TODO: handle exception
            }

        });
        try {
            this.competitorExporter.execute(this.competitorContent);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void execute() {
        this.competitors();
    }

}
