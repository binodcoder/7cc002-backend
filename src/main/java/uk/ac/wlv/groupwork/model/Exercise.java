package uk.ac.wlv.groupwork.model;

import javax.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private String targetMuscleGroups;
    private String difficulty;
    private String equipment;
    private String imageUrl;
    private String videoUrl;

    public Exercise() {
    }

    public Exercise(int id, String name, String description, String targetMuscleGroups, String difficulty, String equipment, String imageUrl, String videoUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.targetMuscleGroups = targetMuscleGroups;
        this.difficulty = difficulty;
        this.equipment = equipment;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
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

    public String getTargetMuscleGroups() {
        return targetMuscleGroups;
    }

    public void setTargetMuscleGroups(String targetMuscleGroups) {
        this.targetMuscleGroups = targetMuscleGroups;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
