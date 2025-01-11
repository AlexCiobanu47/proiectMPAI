package eu.ase.ro.proiect.specification;

import eu.ase.ro.proiect.model.ConferenceRoom;

public class CapacitySpecification implements Specification<ConferenceRoom> {
    private final int minCapacity;

    public CapacitySpecification(int minCapacity) {
        this.minCapacity = minCapacity;
    }

    @Override
    public boolean isSatisfiedBy(ConferenceRoom room) {
        return room.getNumberOfSeats() >= minCapacity;
    }
}
