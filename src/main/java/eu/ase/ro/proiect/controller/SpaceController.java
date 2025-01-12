package eu.ase.ro.proiect.controller;

import eu.ase.ro.proiect.dto.ConferenceRoomRequest;
import eu.ase.ro.proiect.dto.OfficeRequest;
import eu.ase.ro.proiect.enums.PriceUnit;
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
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/space")
public class SpaceController {

    @Autowired
    private SpaceService spaceService;

    @GetMapping("/")
    public String index() {
        return "spaces/index";
    }

    @GetMapping("/create/office")
    public String createOfficePage(Model model) {
        model.addAttribute("officeRequest", new OfficeRequest());
        model.addAttribute("priceUnits", PriceUnit.values());
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
            request.getIsAvailable(),
            request.getPrice(),
            request.getPriceUnit(),
            request.getNoOfDesks(),
            request.getNumberOfSeats(),
            request.isHasAC(),
            request.isHasPrinterAccess()
        );
        return new ResponseEntity<>(office, HttpStatus.CREATED);
    }

    @GetMapping("/create/conferenceroom")
    public String createConferenceRoomPage(Model model) {
        model.addAttribute("conferenceroomRequest", new ConferenceRoomRequest());
        model.addAttribute("priceUnits", PriceUnit.values());
        return "spaces/createConferenceRoom";
    }

    @PostMapping("/create/conferenceroom")
    public ResponseEntity<Space> createConferenceRoom(@RequestBody ConferenceRoomRequest request) {
        ConferenceRoom conferenceRoom = spaceService.createConferenceRoom(
            request.getName(),
            request.getType(),
            request.getSize(),
            request.getFloor(),
            request.getIsAvailable(),
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

    @GetMapping("/revenue")
    public String getRevenue(Model model) {
        int revenue = spaceService.calculateRevenue();
        model.addAttribute("revenue", revenue);
        return "spaces/revenue";
    }
    
}
