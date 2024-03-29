package uk.ac.wlv.groupwork.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.ac.wlv.groupwork.dao.UserRepository;
import uk.ac.wlv.groupwork.dao.WalkParticipantRepository;
import uk.ac.wlv.groupwork.dao.WalkRepository;
import uk.ac.wlv.groupwork.model.User;
import uk.ac.wlv.groupwork.model.Walk;
import uk.ac.wlv.groupwork.model.WalkParticipant;

@Service
public class WalkParticipantService {

    private final UserRepository userRepository;

    private final WalkRepository walkRepository;

    private final WalkParticipantRepository walkParticipantRepository;

    public WalkParticipantService(UserRepository userRepository, WalkRepository walkRepository, WalkParticipantRepository walkParticipantRepository) {
        this.userRepository = userRepository;
        this.walkRepository = walkRepository;
        this.walkParticipantRepository = walkParticipantRepository;
    }

    @Transactional
    public String joinWalk(int userId, int walkId) {

        // Retrieve the user and walk entities from the database.
        User user = userRepository.findById(userId).orElse(null);
        Walk walk = walkRepository.findById(walkId).orElse(null);

        if (user == null || walk == null) {
            return "User or walk not found";
        }

        //Uses the custom method for this using native SQL.
        //This coud not be done with JPQL
        walkRepository.addUserToWalk(user, walk);

        return "User joined the walk successfully";
    }

    @Transactional
    public String leaveWalk(int userId, int walkId) {
        walkParticipantRepository.deleteByUserIdAndWalkId(userId, walkId);
        return "User left the walk successfully";
    }
}
