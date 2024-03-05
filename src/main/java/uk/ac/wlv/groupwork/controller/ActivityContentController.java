package uk.ac.wlv.groupwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.wlv.groupwork.service.ActivityContentService;

@RestController
@RequestMapping("/activity-content")
public class ActivityContentController {

    private final ActivityContentService activityContentService;

    @Autowired
    public ActivityContentController(ActivityContentService activityContentService) {
        this.activityContentService = activityContentService;
    }

    @GetMapping
    public Object getAllActivityContent() {
        return activityContentService.getAll();
    }
}

