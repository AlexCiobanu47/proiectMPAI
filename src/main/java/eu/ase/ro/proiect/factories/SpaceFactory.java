package eu.ase.ro.proiect.factories;

import eu.ase.ro.proiect.enums.PriceUnit;
import eu.ase.ro.proiect.interfaces.SpaceFactoryInterface;
import eu.ase.ro.proiect.model.ConferenceRoom;
import eu.ase.ro.proiect.model.Office;

public class SpaceFactory implements SpaceFactoryInterface{
    @Override
    public Office createOffice(String name, String type, float size, int floor, boolean isAvailable, float price, PriceUnit priceUnit, int noOfDesks, int numberOfSeats, boolean hasAC, boolean hasPrinterAccess) {
        Office office = new Office(name, type, size, floor, isAvailable, price, priceUnit, noOfDesks, numberOfSeats, hasAC, hasPrinterAccess);
        return office;
    }

    @Override
    public ConferenceRoom createConferenceRoom(String name, String type, float size, int floor, boolean isAvailable, float price, PriceUnit priceUnit, boolean hasProjector, boolean hasWhiteboard, int numberOfSeats) {
        ConferenceRoom conferenceRoom = new ConferenceRoom(name, type, size, floor, isAvailable, price, priceUnit, hasProjector, hasWhiteboard, numberOfSeats);
        return conferenceRoom;
    }
}
