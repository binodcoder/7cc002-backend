package uk.ac.wlv.groupwork.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.wlv.groupwork.service.CoachService;
import uk.ac.wlv.groupwork.service.UserService;

@RestController
@RequestMapping("/coach")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping
    public Object get(){
        return coachService.getAll();
    }
}
