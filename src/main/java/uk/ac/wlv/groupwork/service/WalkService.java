package uk.ac.wlv.groupwork.service;

import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.WalkRepository;
import uk.ac.wlv.groupwork.model.Walk;

import java.util.List;
import java.util.Optional;

@Service
public class WalkService {

    private final WalkRepository walkRepository;

    public List<Walk> getAllWalksWithParticipants() {
        return walkRepository.findAllWalksWithParticipants();
    }

    public WalkService(WalkRepository walkRepository) {
        this.walkRepository = walkRepository;
    }

    public List<Walk> getAllWalks() {
        return walkRepository.findAll();
    }

    public Optional<Walk> getWalkById(int id) {
        return walkRepository.findById(id);
    }

    public Walk addWalk(Walk walk) {
        return walkRepository.save(walk);
    }

    public Walk updateWalk(Walk walk) {
        return walkRepository.save(walk);
    }

    public void deleteWalkById(int id) {
        walkRepository.deleteById(id);
    }
}
