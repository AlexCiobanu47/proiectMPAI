package eu.ase.ro.proiect.specification;

import eu.ase.ro.proiect.model.ConferenceRoom;
import eu.ase.ro.proiect.model.Space;

public class HasProjectorSpecification implements Specification<Space>{

    @Override
    public boolean isSatisfiedBy(Space space) {
        return space instanceof ConferenceRoom && ((ConferenceRoom) space).isHasProjector();
    }
}
