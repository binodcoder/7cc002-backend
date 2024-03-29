package uk.ac.wlv.groupwork.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class WalkParticipantId implements Serializable {

    private int userId;

    private int walkId;

    public WalkParticipantId() {
    }

    public WalkParticipantId(int userId, int walkId) {
        this.userId = userId;
        this.walkId = walkId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWalkId() {
        return walkId;
    }

    public void setWalkId(int walkId) {
        this.walkId = walkId;
    }
}
