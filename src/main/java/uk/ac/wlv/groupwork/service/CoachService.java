package uk.ac.wlv.groupwork.service;

import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.CoachRepository;
import uk.ac.wlv.groupwork.model.Coach;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CoachService {

    private final CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    public Optional<Coach> getCoachById(int id) {
        return coachRepository.findById(id);
    }

    public Coach addCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    public Coach updateCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    public void deleteCoachById(int id) {
        coachRepository.deleteById(id);
    }
}
