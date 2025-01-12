package eu.ase.ro.proiect.specification;

import eu.ase.ro.proiect.model.Space;

public class RentedSpecification implements Specification<Space> {
    @Override
    public boolean isSatisfiedBy(Space space) {
        return !space.isAvailable();
    }
}
