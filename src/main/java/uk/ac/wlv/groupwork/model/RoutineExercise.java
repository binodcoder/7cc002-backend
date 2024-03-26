package uk.ac.wlv.groupwork.model;

import javax.persistence.*;

@Entity
@Table(name = "routine_exercises")
public class RoutineExercise {

    @EmbeddedId
    private RoutineExerciseId id;

    @ManyToOne
    @MapsId("routineId")
    @JoinColumn(name = "routine_id")
    private Routine routine;

    @ManyToOne
    @MapsId("exerciseId")
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    public RoutineExercise() {
    }

    public RoutineExercise(RoutineExerciseId id, Routine routine, Exercise exercise) {
        this.id = id;
        this.routine = routine;
        this.exercise = exercise;
    }

    public RoutineExerciseId getId() {
        return id;
    }

    public void setId(RoutineExerciseId id) {
        this.id = id;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
