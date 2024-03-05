package uk.ac.wlv.groupwork.service;

import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.CoachRepository;
import uk.ac.wlv.groupwork.dao.UserRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class CoachService {
    private final CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public Object getAll(){
        try {
            if(coachRepository.findAll().isEmpty()){
                Map<String, String> errorMessage = new HashMap<>();
                errorMessage.put("EMPTY", "NO DATA");
                return errorMessage;
            } else {
                return coachRepository.findAll();
            }
        } catch (Exception e)
        {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("DB ERROR", "ERROR "+e.getMessage()+" ");
            return errorMessage;
        }
    }
}
