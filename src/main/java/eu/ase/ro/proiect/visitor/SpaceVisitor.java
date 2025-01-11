package eu.ase.ro.proiect.visitor;

import eu.ase.ro.proiect.model.ConferenceRoom;
import eu.ase.ro.proiect.model.Office;

public interface SpaceVisitor {
    void visit(Office office);
    void visit(ConferenceRoom conferenceRoom);
}