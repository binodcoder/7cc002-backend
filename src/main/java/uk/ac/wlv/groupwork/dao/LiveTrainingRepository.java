package uk.ac.wlv.groupwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.wlv.groupwork.model.LiveTraining;

@Repository
public interface LiveTrainingRepository extends JpaRepository<LiveTraining, Integer> {
}
