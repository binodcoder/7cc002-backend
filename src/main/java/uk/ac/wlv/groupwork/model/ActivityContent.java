package uk.ac.wlv.groupwork.model;

import javax.persistence.*;

@Entity
@Table(name = "activity_content")
public class ActivityContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private int contentId;

    @Column(name = "activity_id")
    private int activityId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "mediatype")
    private String mediaType;

    @Column(name = "fileurl")
    private String fileUrl;

    public ActivityContent() {
    }

    public ActivityContent(int activityId, int userId, String mediaType, String fileUrl) {
        this.activityId = activityId;
        this.userId = userId;
        this.mediaType = mediaType;
        this.fileUrl = fileUrl;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}

