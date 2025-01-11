package eu.ase.ro.proiect.decorator;

import eu.ase.ro.proiect.model.Space;

public abstract class SpaceDecorator extends Space {
    protected Space decoratedSpace;

    public SpaceDecorator(Space decoratedSpace) {
        super(decoratedSpace.getName(), decoratedSpace.getType(), decoratedSpace.getSize(),
                decoratedSpace.isAvailable(), decoratedSpace.getPrice(), decoratedSpace.getPriceUnit());
        this.decoratedSpace = decoratedSpace;
    }

    @Override
    public String toString() {
        return decoratedSpace.toString();
    }
}