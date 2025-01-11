package eu.ase.ro.proiect.dto;

import eu.ase.ro.proiect.enums.PriceUnit;

public class ConferenceRoomRequest {

    private String name;
    private String type;
    private float size;
    private boolean isAvailable;
    private int floor;
    private float price;
    private PriceUnit priceUnit;
    private int noOfDesks;
    private int numberOfSeats;
    private boolean hasProjector;
    private boolean hasWhiteboard;

    public ConferenceRoomRequest() {
    }

    public ConferenceRoomRequest(String name, String type, float size, boolean isAvailable, int floor, float price, PriceUnit priceUnit, boolean hasProjector, boolean hasWhiteboard, int numberOfSeats) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.isAvailable = isAvailable;
        this.floor = floor;
        this.price = price;
        this.priceUnit = priceUnit;
        this.hasProjector = hasProjector;
        this.hasWhiteboard = hasWhiteboard;
        this.numberOfSeats = numberOfSeats;

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

}
