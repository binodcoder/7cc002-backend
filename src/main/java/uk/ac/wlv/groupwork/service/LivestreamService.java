package uk.ac.wlv.groupwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.LivestreamRepository;
import uk.ac.wlv.groupwork.model.Livestream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LivestreamService {

    private final LivestreamRepository livestreamRepository;

    @Autowired
    public LivestreamService(LivestreamRepository livestreamRepository) {
        this.livestreamRepository = livestreamRepository;
    }

    public Object getAll() {
        try {
            List<Livestream> livestreams = livestreamRepository.findAll();
            if (livestreams.isEmpty()) {
                Map<String, String> errorMessage = new HashMap<>();
                errorMessage.put("ERROR", "NO DATA");
                return errorMessage;
            } else {
                return livestreams;
            }
        } catch (Exception e) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("DB ERROR", "ERROR " + e.getMessage() + " ");
            return errorMessage;
        }
    }
}

