package uk.ac.wlv.groupwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.wlv.groupwork.model.WalkParticipant;
import uk.ac.wlv.groupwork.model.WalkParticipantId;

@Repository
public interface WalkParticipantRepository extends JpaRepository<WalkParticipant, WalkParticipantId> {
    void deleteByUserIdAndWalkId(int userId, int walkId);
}
