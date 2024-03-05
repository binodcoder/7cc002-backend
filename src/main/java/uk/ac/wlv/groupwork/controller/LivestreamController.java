package uk.ac.wlv.groupwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.wlv.groupwork.service.LivestreamService;

@RestController
@RequestMapping("/livestream")
public class LivestreamController {

    private final LivestreamService livestreamService;

    @Autowired
    public LivestreamController(LivestreamService livestreamService) {
        this.livestreamService = livestreamService;
    }

    @GetMapping
    public Object getLivestreams() {
        return livestreamService.getAll();
    }
}

