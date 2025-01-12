package eu.ase.ro.proiect.model;

import eu.ase.ro.proiect.enums.PriceUnit;
import eu.ase.ro.proiect.visitor.RevenueCalculatorVisitor;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ConferenceRoom")
public class ConferenceRoom extends Space{
    private boolean hasProjector;
    private boolean hasWhiteboard;
    private int numberOfSeats;

    public ConferenceRoom() {
        super();
    }

    public ConferenceRoom(String name, String type, float size, int floor, boolean isAvailable, float price, PriceUnit priceUnit, boolean hasProjector, boolean hasWhiteboard, int numberOfSeats) {
        super(name, type, size, floor, isAvailable, price, priceUnit);
        this.hasProjector = hasProjector;
        this.hasWhiteboard = hasWhiteboard;
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    public boolean isHasWhiteboard() {
        return hasWhiteboard;
    }

    public void setHasWhiteboard(boolean hasWhiteboard) {
        this.hasWhiteboard = hasWhiteboard;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public void accept(RevenueCalculatorVisitor visitor) {
        visitor.visit(this);
    }
}
