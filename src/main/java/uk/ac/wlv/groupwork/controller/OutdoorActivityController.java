package uk.ac.wlv.groupwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.wlv.groupwork.model.OutdoorActivity;
import uk.ac.wlv.groupwork.service.OutdoorActivityService;

import java.util.List;

@RestController
@RequestMapping("/outdoor-activities")
public class OutdoorActivityController {

    private final OutdoorActivityService outdoorActivityService;

    @Autowired
    public OutdoorActivityController(OutdoorActivityService outdoorActivityService) {
        this.outdoorActivityService = outdoorActivityService;
    }

    @GetMapping
    public Object getAllOutdoorActivities() {
        return outdoorActivityService.getAllOutdoorActivities();
    }
}

