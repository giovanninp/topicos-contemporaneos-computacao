package com.school.bet;

import com.school.bet.services.CompetitorImporter;
import com.school.bet.services.DataFromXML;
import com.school.bet.services.DataToCSV;
import com.school.bet.services.DatabaseConnector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BetApplication {

	public static void main(String[] args) {
		CompetitorImporter competitorImporter = new CompetitorImporter();
		competitorImporter.execute();

		DatabaseConnector databaseConnector = new DatabaseConnector("jdbc:mysql://localhost:3306/betdb", "bet", "1234");

		DataToCSV dataTo = new DataToCSV(databaseConnector);
		dataTo.execute();

		DataFromXML dataFrom = new DataFromXML(competitorImporter, databaseConnector);
		dataFrom.execute();


		// databaseConnector.query("select * from competitor;", (result) -> {
		// try {
		// String name = result.getString("name");
		// System.out.print("\nNAME: "+ name);
		// } catch (Exception e) {
		// // TODO: handle exception
		// }
		// });

		// databaseConnector.query("select * from bet;", (result) -> {
		// try {
		// String negotiatorResult = result.getString("negotiator_register");
		// } catch (Exception e) {
		// // TODO: handle exception
		// }
		// });

		// databaseConnector.update(" UPDATE competitor SET name='Drauzio Varela' WHERE
		// id = 5;");

		SpringApplication.run(BetApplication.class, args);
	}

}
