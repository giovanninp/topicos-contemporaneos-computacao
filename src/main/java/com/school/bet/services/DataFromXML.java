package com.school.bet.services;

import java.util.List;

import com.school.bet.entities.Competitor;

public class DataFromXML {
    CompetitorImporter competitorImporter;
    DatabaseConnector databaseConnector;

    public DataFromXML(CompetitorImporter competitorImporter, DatabaseConnector databaseConnector) {
        this.competitorImporter = competitorImporter;
        this.databaseConnector = databaseConnector;
    }

    private void importCompetitors() {
        List<Competitor> competitors = competitorImporter.execute();

        this.databaseConnector.update("DELETE FROM competitor;");

        competitors.forEach(competitor -> {
            this.databaseConnector
                    .update(
                            String.format(
                                    "INSERT INTO competitor VALUES (NULL, %s);",
                                    competitor.toCSV()));
        });

    }

    public void execute() {
        this.importCompetitors();
    }
}
