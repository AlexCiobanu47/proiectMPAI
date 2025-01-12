package eu.ase.ro.proiect.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import eu.ase.ro.proiect.enums.PriceUnit;
import eu.ase.ro.proiect.factories.SpaceFactory;
import eu.ase.ro.proiect.model.ConferenceRoom;
import eu.ase.ro.proiect.model.Office;
import eu.ase.ro.proiect.model.Space;
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
    public Office createOffice(String name, String type, float size, int floor, boolean isAvailable, float price, PriceUnit priceUnit, int noOfDesks, int numberOfSeats, boolean hasAC, boolean hasPrinterAccess) {
        Office office = spaceFactory.createOffice(name, type, size, floor, isAvailable, price, priceUnit, noOfDesks, numberOfSeats, hasAC, hasPrinterAccess);
        try{
            spaceRepository.save(office);
            return office;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    @Transactional
    public ConferenceRoom createConferenceRoom(String name, String type, float size, int floor, boolean isAvailable, float price, PriceUnit priceUnit, boolean hasProjector, boolean hasWhiteboard, int numberOfSeats) {
        ConferenceRoom conferenceRoom = spaceFactory.createConferenceRoom(name, type, size, floor, isAvailable, price, priceUnit, hasProjector, hasWhiteboard, numberOfSeats);
        try{
            spaceRepository.save(conferenceRoom);
            return conferenceRoom;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Space> getAll() {
        return spaceRepository.findAll()
                .stream()
                .toList();
    }

    public List<Space> getAvailable() {
        return spaceRepository.findAll()
                .stream()
                .filter(Space::isAvailable)
                .toList();
    }

    public Space findById(Long id) {
        return spaceRepository.findById(id).orElseThrow(() -> new RuntimeException("Space not found"));
    }

    public void rentSpace(Long spaceId) {
        try {
            Space space = spaceRepository.findById(spaceId).orElseThrow(() -> new RuntimeException("Space not found"));
            if (!space.isAvailable()) {
                throw new RuntimeException("Space is not available");
            }
            space.setAvailable(false);
            spaceRepository.save(space);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}