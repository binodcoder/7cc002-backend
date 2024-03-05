package uk.ac.wlv.groupwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.OutdoorActivityRepository;
import uk.ac.wlv.groupwork.model.OutdoorActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OutdoorActivityService {

    private final OutdoorActivityRepository outdoorActivityRepository;

    @Autowired
    public OutdoorActivityService(OutdoorActivityRepository outdoorActivityRepository) {
        this.outdoorActivityRepository = outdoorActivityRepository;
    }

    public Object getAllOutdoorActivities() {
        try {
            List<OutdoorActivity> outdoorActivities = outdoorActivityRepository.findAll();
            if (outdoorActivities.isEmpty()) {
                Map<String, String> errorMessage = new HashMap<>();
                errorMessage.put("ERROR", "NO DATA");
                return errorMessage;
            } else {
                return outdoorActivities;
            }
        } catch (Exception e) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("DB ERROR", "ERROR " + e.getMessage() + " ");
            return errorMessage;
        }
    }
}

