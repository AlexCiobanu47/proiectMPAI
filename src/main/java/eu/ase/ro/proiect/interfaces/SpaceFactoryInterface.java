package eu.ase.ro.proiect.interfaces;

import eu.ase.ro.proiect.enums.PriceUnit;
import eu.ase.ro.proiect.model.ConferenceRoom;
import eu.ase.ro.proiect.model.Office;

public interface SpaceFactoryInterface {
    Office createOffice(String name, String type, float size, boolean isAvailable, int floor, float price, PriceUnit priceUnit, int noOfDesks, int numberOfSeats, boolean hasAC, boolean hasPrinterAccess);
    ConferenceRoom createConferenceRoom(String name, String type, float size, boolean isAvailable, float price, PriceUnit priceUnit, boolean hasProjector, boolean hasWhiteboard, int numberOfSeats);
}
