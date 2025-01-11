package eu.ase.ro.proiect.specification;

import eu.ase.ro.proiect.model.ConferenceRoom;

public class HasProjectorSpecification implements Specification<ConferenceRoom>{
    @Override
    public boolean isSatisfiedBy(ConferenceRoom conferenceRoom) {
        return conferenceRoom.isHasProjector();
    }
}
