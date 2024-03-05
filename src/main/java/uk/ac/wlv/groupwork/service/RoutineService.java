package uk.ac.wlv.groupwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.RoutineRepository;
import uk.ac.wlv.groupwork.model.Routine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoutineService {

    private final RoutineRepository routineRepository;

    @Autowired
    public RoutineService(RoutineRepository routineRepository) {
        this.routineRepository = routineRepository;
    }

    public Object getAll() {
        try {
            List<Routine> routines = routineRepository.findAll();
            if (routines.isEmpty()) {
                Map<String, String> errorMessage = new HashMap<>();
                errorMessage.put("EMPTY", "NO DATA");
                return errorMessage;
            } else {
                return routines;
            }
        } catch (Exception e) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("DB ERROR", "ERROR " + e.getMessage() + " ");
            return errorMessage;
        }
    }
}

