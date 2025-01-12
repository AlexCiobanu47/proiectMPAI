package eu.ase.ro.proiect.controller;

import eu.ase.ro.proiect.dto.ConferenceRoomRequest;
import eu.ase.ro.proiect.dto.OfficeRequest;
import eu.ase.ro.proiect.model.ConferenceRoom;
import eu.ase.ro.proiect.model.Office;
import eu.ase.ro.proiect.model.Space;
import eu.ase.ro.proiect.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/space")
public class SpaceController {

    @Autowired
    private SpaceService spaceService;

    @PostMapping("/create/office")
    public ResponseEntity<Space> createOffice(@RequestBody OfficeRequest request) {
        Office office = spaceService.createOffice(
            request.getName(),
            request.getType(),
            request.getSize(),
            request.isAvailable(),
            request.getFloor(),
            request.getPrice(),
            request.getPriceUnit(),
            request.getNoOfDesks(),
            request.getNumberOfSeats(),
            request.isHasAC(),
            request.isHasPrinterAccess()
        );
        return new ResponseEntity<>(office, HttpStatus.CREATED);
    }

    @PostMapping("/create/conferenceroom")
    public ResponseEntity<Space> createConferenceRoom(@RequestBody ConferenceRoomRequest request) {
        ConferenceRoom conferenceRoom = spaceService.createConferenceRoom(
            request.getName(),
            request.getType(),
            request.getSize(),
            request.isAvailable(),
            request.getPrice(),
            request.getPriceUnit(),
            request.isHasProjector(),
            request.isHasWhiteboard(),
            request.getNumberOfSeats()
        );
        return new ResponseEntity<>(conferenceRoom, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Space>> getAllSpaces() {
        List<Space> spaces = spaceService.getAll();
        return new ResponseEntity<>(spaces, HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Space>> getAvailableSpaces() {
        List<Space> spaces = spaceService.getAvailable();
        return new ResponseEntity<>(spaces, HttpStatus.OK);
    }

    @PostMapping("/rent/{spaceId}")
    public ResponseEntity<String> rentSpace(@PathVariable Long spaceId) {
        spaceService.rentSpace(spaceId);
        return new ResponseEntity<>("rented space with id " + spaceId, HttpStatus.OK);
    }
}
