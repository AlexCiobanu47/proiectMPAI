package eu.ase.ro.proiect.dto;

import eu.ase.ro.proiect.enums.PriceUnit;

public class OfficeRequest {

    private String name;
    private String type;
    private float size;
    private boolean isAvailable;
    private int floor;
    private float price;
    private PriceUnit priceUnit;
    private int noOfDesks;
    private int numberOfSeats;
    private boolean hasAC;
    private boolean hasPrinterAccess;

    public OfficeRequest() {
    }

    public OfficeRequest(String name, String type, float size, int floor, boolean isAvailable, float price, PriceUnit priceUnit, int noOfDesks, int numberOfSeats, boolean hasAC, boolean hasPrinterAccess) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.floor = floor;
        this.isAvailable = isAvailable;
        this.price = price;
        this.priceUnit = priceUnit;
        this.noOfDesks = noOfDesks;
        this.numberOfSeats = numberOfSeats;
        this.hasAC = hasAC;
        this.hasPrinterAccess = hasPrinterAccess;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public PriceUnit getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(PriceUnit priceUnit) {
        this.priceUnit = priceUnit;
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

}
