package uk.ac.wlv.groupwork.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;

@Entity
@Table(name = "walk_participants")
public class WalkParticipant {

    @EmbeddedId
    private WalkParticipantId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonUnwrapped
    private User user;

    @ManyToOne
    @MapsId("walkId")
    @JoinColumn(name = "walk_id")
    @JsonIgnore
  //  @JsonIgnoreProperties("participants") // Ignore the 'participants' field to break the circular reference
    private Walk walk;



    public WalkParticipant() {
    }

    public WalkParticipant(User user, Walk walk) {
        this.user = user;
        this.walk = walk;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Walk getWalk() {
        return walk;
    }

    public void setWalk(Walk walk) {
        this.walk = walk;
    }
}
