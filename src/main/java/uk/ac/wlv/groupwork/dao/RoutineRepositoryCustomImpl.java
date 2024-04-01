package uk.ac.wlv.groupwork.dao;

import uk.ac.wlv.groupwork.model.Exercise;
import uk.ac.wlv.groupwork.model.Routine;
import uk.ac.wlv.groupwork.model.User;
import uk.ac.wlv.groupwork.model.Walk;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RoutineRepositoryCustomImpl implements RoutineRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addExerciseToRoutine(Exercise exercise, Routine routine) {
        // Execute native SQL query to insert a record into routine_exercises table
        entityManager.createNativeQuery("INSERT INTO routine_exercises (exercise_id, routine_id) VALUES (?, ?)")
                .setParameter(1, exercise.getId())
                .setParameter(2, routine.getId())
                .executeUpdate();
    }
}
