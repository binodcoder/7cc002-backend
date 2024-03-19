package uk.ac.wlv.groupwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.OutdoorActivityRepository;
import uk.ac.wlv.groupwork.model.OutdoorActivity;

import java.util.List;
import java.util.Optional;

@Service
public class OutdoorActivityService {

    private final OutdoorActivityRepository outdoorActivityRepository;

    public OutdoorActivityService(OutdoorActivityRepository outdoorActivityRepository) {
        this.outdoorActivityRepository = outdoorActivityRepository;
    }

    public List<OutdoorActivity> getAllOutdoorActivities() {
        return outdoorActivityRepository.findAll();
    }

    public Optional<OutdoorActivity> getOutdoorActivityById(int id) {
        return outdoorActivityRepository.findById(id);
    }

    public OutdoorActivity addOutdoorActivity(OutdoorActivity outdoorActivity) {
        return outdoorActivityRepository.save(outdoorActivity);
    }

    public OutdoorActivity updateOutdoorActivity(OutdoorActivity outdoorActivity) {
        return outdoorActivityRepository.save(outdoorActivity);
    }

    public void deleteOutdoorActivityById(int id) {
        outdoorActivityRepository.deleteById(id);
    }
}
