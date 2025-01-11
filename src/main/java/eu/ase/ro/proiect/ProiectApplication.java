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

		// Creăm un Office simplu
		Office office = new Office("Premium Office", "Office", 50.0f, 3, true, 200.0f, PriceUnit.PER_HOUR, 5, 10, true, true);

		System.out.println("Before decoration:");
		System.out.println(office);

		// Adăugăm Wi-Fi
		WiFiDecorator officeWithWiFi = new WiFiDecorator(office, 50.0f);

		// Adăugăm parcare
		ParkingDecorator officeWithWiFiAndParking = new ParkingDecorator(officeWithWiFi, 30.0f);

		System.out.println("\nAfter adding Wi-Fi and Parking:");
		System.out.println(officeWithWiFiAndParking);

		// Preț total
		System.out.println("\nTotal price: " + officeWithWiFiAndParking.getPrice());
	}

}
