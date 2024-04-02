package uk.ac.wlv.groupwork.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;

@Entity
@Table(name = "routine_exercises")
public class RoutineExercise {

    @EmbeddedId
    private RoutineExerciseId id;

    @ManyToOne
    @MapsId("routineId")
    @JoinColumn(name = "routine_id")
    @JsonIgnore
    private Routine routine;

    @ManyToOne
    @MapsId("exerciseId")
    @JoinColumn(name = "exercise_id")
    @JsonUnwrapped
    private Exercise exercise;

    public RoutineExercise() {
    }

    public RoutineExercise(Routine routine, Exercise exercise) {
        this.routine = routine;
        this.exercise = exercise;
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
