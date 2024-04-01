package uk.ac.wlv.groupwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.wlv.groupwork.model.RoutineExercise;
import uk.ac.wlv.groupwork.model.RoutineExerciseId;

@Repository
public interface RoutineExerciseRepository extends JpaRepository<RoutineExercise, RoutineExerciseId> {
    void deleteByExerciseIdAndRoutineId(int exerciseId, int routineId);
}
