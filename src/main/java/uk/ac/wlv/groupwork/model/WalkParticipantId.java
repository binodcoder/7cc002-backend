package uk.ac.wlv.groupwork.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class WalkParticipantId implements Serializable {

    private Long userId;

    private Long walkId;

    public WalkParticipantId() {
    }

    public WalkParticipantId(Long userId, Long walkId) {
        this.userId = userId;
        this.walkId = walkId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getWalkId() {
        return walkId;
    }

    public void setWalkId(Long walkId) {
        this.walkId = walkId;
    }
}
