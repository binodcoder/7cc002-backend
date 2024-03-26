package uk.ac.wlv.groupwork.model;

import javax.persistence.*;

@Entity
@Table(name = "walk_media")
public class WalkMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "walk_id")
    private Integer walkId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "media_url")
    private String mediaUrl;

    public WalkMedia() {
    }

    public WalkMedia(int id, Integer walkId, Integer userId, String mediaUrl) {
        this.id = id;
        this.walkId = walkId;
        this.userId = userId;
        this.mediaUrl = mediaUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getWalkId() {
        return walkId;
    }

    public void setWalkId(Integer walkId) {
        this.walkId = walkId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }
}
