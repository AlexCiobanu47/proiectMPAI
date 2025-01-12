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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/space")
public class SpaceController {

    @Autowired
    private SpaceService spaceService;

    @GetMapping("/create/office")
    public String createOfficePage() {
        return "spaces/createOffice";
    }

    @PostMapping("/create/office")
    public ResponseEntity<Space> createOffice(@RequestBody OfficeRequest request) {
        System.out.println(request);
        Office office = spaceService.createOffice(
            request.getName(),
            request.getType(),
            request.getSize(),
            request.getFloor(),
            request.isAvailable(),
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
            request.getFloor(),
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
    public String getAllSpaces(Model model) {
        List<Space> spaces = spaceService.getAll();
        model.addAttribute("spaces", spaces);
        return "spaces/allSpaces";
    }

    @GetMapping("/available")
    public String getAvailableSpaces(Model model) {
        List<Space> spaces = spaceService.getAvailable();
        model.addAttribute("spaces", spaces);
        return "spaces/availableSpaces";
    }

    @PostMapping("/rent/{spaceId}")
    public String rentSpace(@PathVariable Long spaceId, Model model) {
        Space space = spaceService.findById(spaceId);
        spaceService.rentSpace(spaceId);
        model.addAttribute("space", space);
        return "spaces/rentSpace";
    }
}
