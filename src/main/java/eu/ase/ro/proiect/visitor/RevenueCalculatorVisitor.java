package eu.ase.ro.proiect.visitor;

import eu.ase.ro.proiect.model.ConferenceRoom;
import eu.ase.ro.proiect.model.Office;

public class RevenueCalculatorVisitor implements SpaceVisitor {
    private float totalRevenue = 0;

    @Override
    public void visit(Office office) {
        totalRevenue += office.getPrice();
    }

    @Override
    public void visit(ConferenceRoom conferenceRoom) {
        totalRevenue += conferenceRoom.getPrice();
    }

    public float getTotalRevenue() {
        return totalRevenue;
    }
}
