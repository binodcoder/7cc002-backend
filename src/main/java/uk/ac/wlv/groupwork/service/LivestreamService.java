package uk.ac.wlv.groupwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.LivestreamRepository;
import uk.ac.wlv.groupwork.model.Livestream;

import java.util.List;
import java.util.Optional;

@Service
public class LivestreamService {

    private final LivestreamRepository livestreamRepository;

    public LivestreamService(LivestreamRepository livestreamRepository) {
        this.livestreamRepository = livestreamRepository;
    }

    public List<Livestream> getAllLivestreams() {
        return livestreamRepository.findAll();
    }

    public Optional<Livestream> getLivestreamById(int id) {
        return livestreamRepository.findById(id);
    }

    public Livestream addLivestream(Livestream livestream) {
        return livestreamRepository.save(livestream);
    }

    public Livestream updateLivestream(Livestream livestream) {
        return livestreamRepository.save(livestream);
    }

    public void deleteLivestreamById(int id) {
        livestreamRepository.deleteById(id);
    }
}
