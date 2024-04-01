package uk.ac.wlv.groupwork.dao;

import uk.ac.wlv.groupwork.model.Exercise;
import uk.ac.wlv.groupwork.model.Routine;

public interface RoutineRepositoryCustom {
    void addExerciseToRoutine(Exercise exercise, Routine routine);
}
