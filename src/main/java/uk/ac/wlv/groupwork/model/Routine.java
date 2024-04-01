package uk.ac.wlv.groupwork.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "routines")
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private int duration;

    @Enumerated(EnumType.STRING)
    private Source source;

    @OneToMany(mappedBy = "routine")
    private List<RoutineExercise> exercises;

    public Routine() {
    }

    public Routine(int id, String name, String description, Difficulty difficulty, int duration, Source source) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.duration = duration;
        this.source = source;
    }

    public Routine(int id, String name, String description, Difficulty difficulty, int duration, Source source, List<RoutineExercise> exercises) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.duration = duration;
        this.source = source;
        this.exercises = exercises;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public List<RoutineExercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<RoutineExercise> exercises) {
        this.exercises = exercises;
    }
}
