package uk.ac.wlv.groupwork.service;

import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.RoutineRepository;
import uk.ac.wlv.groupwork.model.Routine;

import java.util.List;
import java.util.Optional;

@Service
public class RoutineService {

    private final RoutineRepository routineRepository;

    public RoutineService(RoutineRepository routineRepository) {
        this.routineRepository = routineRepository;
    }

    public List<Routine> getAllRoutines() {
        return routineRepository.findAll();
    }

    public Optional<Routine> getRoutineById(int id) {
        return routineRepository.findById(id);
    }

    public Routine addRoutine(Routine routine) {
        return routineRepository.save(routine);
    }

    public Routine updateRoutine(Routine routine) {
        return routineRepository.save(routine);
    }

    public void deleteRoutineById(int id) {
        routineRepository.deleteById(id);
    }
}
