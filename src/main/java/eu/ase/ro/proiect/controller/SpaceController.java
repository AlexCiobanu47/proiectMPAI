package eu.ase.ro.proiect.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ase.ro.proiect.dto.ConferenceRoomRequest;
import eu.ase.ro.proiect.dto.OfficeRequest;
import eu.ase.ro.proiect.model.ConferenceRoom;
import eu.ase.ro.proiect.model.Office;
import eu.ase.ro.proiect.repository.SpaceRepository;
import eu.ase.ro.proiect.service.SpaceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/space")
public class SpaceController {
    private final SpaceService spaceService;

    public SpaceController(SpaceService spaceService, SpaceRepository spaceRepository) {
        this.spaceService = spaceService;
    }

    @PostMapping("/office")
    public Office createOffice(@RequestBody OfficeRequest request) {
        return spaceService.createOffice(
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
    }

    @PostMapping("/conferenceroom")
    public ConferenceRoom creatConferenceRoom(@RequestBody ConferenceRoomRequest request) {
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
        return conferenceRoom;
    }
    
}
