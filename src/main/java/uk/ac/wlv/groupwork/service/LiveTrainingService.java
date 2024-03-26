package uk.ac.wlv.groupwork.service;

import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.LiveTrainingRepository;
import uk.ac.wlv.groupwork.model.LiveTraining;

import java.util.List;
import java.util.Optional;

@Service
public class LiveTrainingService {

    private final LiveTrainingRepository liveTrainingRepository;

    public LiveTrainingService(LiveTrainingRepository liveTrainingRepository) {
        this.liveTrainingRepository = liveTrainingRepository;
    }

    public List<LiveTraining> getAllLiveTrainings() {
        return liveTrainingRepository.findAll();
    }

    public Optional<LiveTraining> getLiveTrainingById(int id) {
        return liveTrainingRepository.findById(id);
    }

    public LiveTraining addLiveTraining(LiveTraining liveTraining) {
        return liveTrainingRepository.save(liveTraining);
    }

    public LiveTraining updateLiveTraining(LiveTraining liveTraining) {
        return liveTrainingRepository.save(liveTraining);
    }

    public void deleteLiveTrainingById(int id) {
        liveTrainingRepository.deleteById(id);
    }
}
