package uk.ac.wlv.groupwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.wlv.groupwork.model.WalkMedia;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalkMediaRepository extends JpaRepository<WalkMedia, Integer> {
    //Optional<WalkMedia> getWalkMediaByWalkId(int walkId);
    List<WalkMedia> getWalkMediaByWalkId(int walkId);
}
