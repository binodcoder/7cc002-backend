package uk.ac.wlv.groupwork.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.wlv.groupwork.service.WalkParticipantService;


@RestController
public class WalkParticipantController {

    private final WalkParticipantService walkParticipantService;

    public WalkParticipantController(WalkParticipantService walkParticipantService) {
        this.walkParticipantService = walkParticipantService;
    }

    @PostMapping("/join-walk")
    public ResponseEntity<String> joinWalk(
            @RequestParam("user_id") int userId,
            @RequestParam("walk_id") int walkId) {

        String result = walkParticipantService.joinWalk(userId, walkId);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{walkId}/leave/{userId}")
    public String leaveWalk(@PathVariable int walkId, @PathVariable int userId) {
        return walkParticipantService.leaveWalk(userId, walkId);
    }
}
