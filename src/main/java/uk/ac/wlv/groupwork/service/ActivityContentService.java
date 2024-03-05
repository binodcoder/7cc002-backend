package uk.ac.wlv.groupwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.ActivityContentRepository;
import uk.ac.wlv.groupwork.model.ActivityContent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityContentService {

    private final ActivityContentRepository activityContentRepository;

    @Autowired
    public ActivityContentService(ActivityContentRepository activityContentRepository) {
        this.activityContentRepository = activityContentRepository;
    }

    public Object getAll() {
        try {
            List<ActivityContent> activityContents = activityContentRepository.findAll();
            if (activityContents.isEmpty()) {
                Map<String, String> errorMessage = new HashMap<>();
                errorMessage.put("ERROR", "NO DATA");
                return errorMessage;
            } else {
                return activityContents;
            }
        } catch (Exception e) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("DB ERROR", "ERROR " + e.getMessage() + " ");
            return errorMessage;
        }
    }
}

