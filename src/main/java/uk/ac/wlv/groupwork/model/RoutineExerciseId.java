package uk.ac.wlv.groupwork.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RoutineExerciseId implements Serializable {

    private int routineId;
    private int exerciseId;

    public RoutineExerciseId() {
    }

    public RoutineExerciseId(int routineId, int exerciseId) {
        this.routineId = routineId;
        this.exerciseId = exerciseId;
    }

    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(int routineId) {
        this.routineId = routineId;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }
}
