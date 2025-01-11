package eu.ase.ro.proiect.service;

import org.springframework.stereotype.Service;

import eu.ase.ro.proiect.enums.PriceUnit;
import eu.ase.ro.proiect.factories.SpaceFactory;
import eu.ase.ro.proiect.model.ConferenceRoom;
import eu.ase.ro.proiect.model.Office;
import eu.ase.ro.proiect.repository.SpaceRepository;
import jakarta.transaction.Transactional;

@Service
public class SpaceService {
    private final SpaceFactory spaceFactory;
    private final SpaceRepository spaceRepository;
    
    public SpaceService(SpaceFactory spaceFactory, SpaceRepository spaceRepository) {
        this.spaceFactory = spaceFactory;
        this.spaceRepository = spaceRepository;
    }
    @Transactional
    public Office createOffice(String name, String type, float size, boolean isAvailable, int floor, float price, PriceUnit priceUnit, int noOfDesks, int numberOfSeats, boolean hasAC, boolean hasPrinterAccess) {
        Office office = spaceFactory.createOffice(name, type, size, isAvailable, floor, price, priceUnit, noOfDesks, numberOfSeats, hasAC, hasPrinterAccess);
        spaceRepository.save(office);
        return office;
    }
    @Transactional
    public ConferenceRoom createConferenceRoom(String name, String type, float size, boolean isAvailable, float price, PriceUnit priceUnit, boolean hasProjector, boolean hasWhiteboard, int numberOfSeats) {
        return spaceFactory.createConferenceRoom(name, type, size, isAvailable, price, priceUnit, hasProjector, hasWhiteboard, numberOfSeats);
    }
}