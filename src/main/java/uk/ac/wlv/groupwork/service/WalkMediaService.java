package uk.ac.wlv.groupwork.service;

import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.WalkMediaRepository;
import uk.ac.wlv.groupwork.model.WalkMedia;

import java.util.List;
import java.util.Optional;

@Service
public class WalkMediaService {

    private final WalkMediaRepository walkMediaRepository;

    public WalkMediaService(WalkMediaRepository walkMediaRepository) {
        this.walkMediaRepository = walkMediaRepository;
    }

    public List<WalkMedia> getAllWalkMedia() {
        return walkMediaRepository.findAll();
    }

    public Optional<WalkMedia> getWalkMediaById(int id) {
        return walkMediaRepository.findById(id);
    }

    public List<WalkMedia> getWalkMediaByWalkId(int walkId) {
        return walkMediaRepository.getWalkMediaByWalkId(walkId);
    }

    public WalkMedia addWalkMedia(WalkMedia walkMedia) {
        return walkMediaRepository.save(walkMedia);
    }

    public WalkMedia updateWalkMedia(WalkMedia walkMedia) {
        return walkMediaRepository.save(walkMedia);
    }

    public void deleteWalkMediaById(int id) {
        walkMediaRepository.deleteById(id);
    }
}
