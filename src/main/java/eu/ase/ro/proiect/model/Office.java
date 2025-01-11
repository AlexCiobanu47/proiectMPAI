package eu.ase.ro.proiect.model;

import eu.ase.ro.proiect.enums.PriceUnit;
import eu.ase.ro.proiect.visitor.RevenueCalculatorVisitor;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Office")
public class Office extends Space{
    private int noOfDesks;
    private int numberOfSeats;
    private boolean hasAC;
    private boolean hasPrinterAccess;

    public Office() {
        super();
    }

    public Office(String name, String type, float size, int floor, boolean isAvailable, float price, PriceUnit priceUnit, int noOfDesks, int numberOfSeats, boolean hasAC, boolean hasPrinterAccess) {
        super(name, type, size, isAvailable, price, priceUnit);
        this.noOfDesks = noOfDesks;
        this.numberOfSeats = numberOfSeats;
        this.hasAC = hasAC;
        this.hasPrinterAccess = hasPrinterAccess;
    }

    public int getNoOfDesks() {
        return noOfDesks;
    }

    public void setNoOfDesks(int noOfDesks) {
        this.noOfDesks = noOfDesks;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isHasAC() {
        return hasAC;
    }

    public void setHasAC(boolean hasAC) {
        this.hasAC = hasAC;
    }

    public boolean isHasPrinterAccess() {
        return hasPrinterAccess;
    }

    public void setHasPrinterAccess(boolean hasPrinterAccess) {
        this.hasPrinterAccess = hasPrinterAccess;
    }

    @Override
    public void accept(RevenueCalculatorVisitor visitor) {
        visitor.visit(this);
    }

}
