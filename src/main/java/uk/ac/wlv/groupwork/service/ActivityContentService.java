package uk.ac.wlv.groupwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.ActivityContentRepository;
import uk.ac.wlv.groupwork.model.ActivityContent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ActivityContentService {

    private final ActivityContentRepository activityContentRepository;

    public ActivityContentService(ActivityContentRepository activityContentRepository) {
        this.activityContentRepository = activityContentRepository;
    }

    public List<ActivityContent> getAllActivityContents() {
        return activityContentRepository.findAll();
    }

    public Optional<ActivityContent> getActivityContentById(int id) {
        return activityContentRepository.findById(id);
    }

    public ActivityContent addActivityContent(ActivityContent activityContent) {
        return activityContentRepository.save(activityContent);
    }

    public ActivityContent updateActivityContent(ActivityContent activityContent) {
        return activityContentRepository.save(activityContent);
    }

    public void deleteActivityContentById(int id) {
        activityContentRepository.deleteById(id);
    }
}
