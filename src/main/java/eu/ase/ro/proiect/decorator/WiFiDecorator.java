package eu.ase.ro.proiect.decorator;

import eu.ase.ro.proiect.model.Space;
import eu.ase.ro.proiect.visitor.RevenueCalculatorVisitor;

public class WiFiDecorator extends SpaceDecorator {
    private final float wifiPrice;

    public WiFiDecorator(Space decoratedSpace, float wifiPrice) {
        super(decoratedSpace);
        this.wifiPrice = wifiPrice;
    }

    @Override
    public float getPrice() {
        return decoratedSpace.getPrice() + wifiPrice; // Adăugăm costul Wi-Fi-ului la prețul existent
    }

    @Override
    public void accept(RevenueCalculatorVisitor visitor) {

    }

    @Override
    public String toString() {
        return decoratedSpace.toString() + ", with Wi-Fi (+" + wifiPrice + ")";
    }
}