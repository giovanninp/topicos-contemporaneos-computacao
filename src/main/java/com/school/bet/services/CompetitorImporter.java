package com.school.bet.services;

import java.util.ArrayList;
import java.util.List;

import com.school.bet.entities.Competitor;

public class CompetitorImporter {
    private ImporterService importer;
    private List<String> foundCompetitorsStrings;

    public CompetitorImporter() {
        this.foundCompetitorsStrings = new ArrayList<String>();
        this.importer = new ImporterService("C:\\Users\\giova\\Dev\\topicos-contemporaneos-computacao\\test.txt",
                (String t, String v) -> {

                    if (t.compareTo("Competitor") == 0) {
                        this.foundCompetitorsStrings.add("");
                    }

                    if (t.compareTo("Competitor") != 0 && !t.isEmpty() && !v.isEmpty()
                            && this.foundCompetitorsStrings.size() > 0) {
                        this.foundCompetitorsStrings.set(this.foundCompetitorsStrings.size() - 1,
                                this.foundCompetitorsStrings.get(this.foundCompetitorsStrings.size() - 1)
                                        + String.format("%s=%s;", t, v));
                        System.out.format("t: %s v: %s\n", t, v);
                    }
                }, java.util.Optional.empty());
    }

    String[] getKeyValue(String value) {
        return value.split("=");
    }

    Competitor getCompetitor(String competitorStr) {
        String[] attrs = competitorStr.split(";");

        String name = "";
        Long registration = (long) 0;
        Float performance = (float) 0;
        Float standard = (float) 0;

        for (String keyValue : attrs) {
            String[] attr = getKeyValue(keyValue);
            String key = attr[0];
            String value = attr[1];

            if (key.equals("name")) {
                name = value;
            }

            if (key.equals("registration")) {
                registration = Long.parseLong(value);
            }

            if (key.equals("performance")) {
                performance = Float.parseFloat(value);
            }

            if (key.equals("standard")) {
                standard = Float.parseFloat(value);
            }
        }

        return new Competitor(registration, name, performance, standard);
    }

    public List<Competitor> execute() {
        List<Competitor> competitors = new ArrayList<Competitor>();
        this.importer.execute();

        this.foundCompetitorsStrings.forEach(competitorString -> {
            Competitor newCompetitor = getCompetitor(competitorString);
            competitors.add(newCompetitor);
        });

        this.foundCompetitorsStrings.clear();

        return competitors;
    }
}
