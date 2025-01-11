package eu.ase.ro.proiect;

import eu.ase.ro.proiect.decorator.ParkingDecorator;
import eu.ase.ro.proiect.decorator.WiFiDecorator;
import eu.ase.ro.proiect.enums.PriceUnit;
import eu.ase.ro.proiect.model.Office;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProiectApplication {

	public static void main(String[] args) {
//		test commit
		SpringApplication.run(ProiectApplication.class, args);

		// cream office simplu
		Office office = new Office("Premium Office", "Office", 50.0f, 3, true, 200.0f, PriceUnit.PER_HOUR, 5, 10, true, true);

		System.out.println("Before decoration:");
		System.out.println(office);

		// add wife
		WiFiDecorator officeWithWiFi = new WiFiDecorator(office, 50.0f);

		// add parcare
		ParkingDecorator officeWithWiFiAndParking = new ParkingDecorator(officeWithWiFi, 30.0f);

		System.out.println("\nAfter adding Wi-Fi and Parking:");
		System.out.println(officeWithWiFiAndParking);

		// pret total
		System.out.println("\nTotal price: " + officeWithWiFiAndParking.getPrice());

		// cream o lista de spatii
		List<Space> spaces = new ArrayList<>();
		spaces.add(new Office("Standard Office", "Office", 30.0f, 2, true, 150.0f, PriceUnit.PER_DAY, 3, 6, true, false));
		spaces.add(new ConferenceRoom("Large Conference Room", "ConferenceRoom", 100.0f, true, 500.0f, PriceUnit.PER_HOUR, true, true, 50));
		spaces.add(new Office("Premium Office", "Office", 50.0f, 3, true, 250.0f, PriceUnit.PER_HOUR, 5, 10, true, true));

		// aplicam visitor pt calcul venit
		RevenueCalculatorVisitor revenueVisitor = new RevenueCalculatorVisitor();
		for (Space space : spaces) {
			space.accept(revenueVisitor);
		}

		System.out.println("Total estimated revenue: " + revenueVisitor.getTotalRevenue());
	}

}
