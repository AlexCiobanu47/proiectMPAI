package eu.ase.ro.proiect.service;

import eu.ase.ro.proiect.model.Space;
import eu.ase.ro.proiect.specification.AvailabilitySpecification;
import eu.ase.ro.proiect.specification.RentedSpecification;

import java.util.List;
import java.util.stream.Collectors;

public class RoomFilterService {
    public List<Space> filterAvailableRooms(List<Space> spaces){
        AvailabilitySpecification availableSpec = new AvailabilitySpecification();
        return spaces.stream().filter(availableSpec::isSatisfiedBy).collect(Collectors.toList());
    }

    public List<Space> filterRentedRooms(List<Space> spaces){
        RentedSpecification rentedSpecification = new RentedSpecification();
        return spaces.stream().filter(rentedSpecification::isSatisfiedBy).collect(Collectors.toList());
    }
}
