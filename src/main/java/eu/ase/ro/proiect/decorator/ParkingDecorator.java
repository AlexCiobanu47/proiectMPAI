package eu.ase.ro.proiect.decorator;

import eu.ase.ro.proiect.model.Space;
import eu.ase.ro.proiect.visitor.RevenueCalculatorVisitor;

public class ParkingDecorator extends SpaceDecorator {
    private final float parkingPrice;

    public ParkingDecorator(Space decoratedSpace, float parkingPrice) {
        super(decoratedSpace);
        this.parkingPrice = parkingPrice;
    }

    @Override
    public float getPrice() {
        return decoratedSpace.getPrice() + parkingPrice; // add the cost of parking to the existing price
    }

    @Override
    public void accept(RevenueCalculatorVisitor visitor) {

    }

    @Override
    public String toString() {
        return decoratedSpace.toString() + ", with Parking (+" + parkingPrice + ")";
    }
}