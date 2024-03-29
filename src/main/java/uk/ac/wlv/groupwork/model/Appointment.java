package uk.ac.wlv.groupwork.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "trainer_id")
    private int trainerId;

    @Column(name = "user_id")
    private int userId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(notes = "The date of the appointment (YYYY-MM-DD)", example = "2024-04-04")
    private Date date;

    @JsonFormat(pattern = "HH:mm:ss")
    @ApiModelProperty(notes = "The start time of the appointment (HH:mm:ss)", example = "12:15:30")
    @Column(name = "start_time")
    private Time startTime;

    @JsonFormat(pattern = "HH:mm:ss")
    @ApiModelProperty(notes = "The end time of the appointment (HH:mm:ss)", example = "12:30:00")
    @Column(name = "end_time")
    private Time endTime;

    @Column(name = "remark")
    private String remark;

    public Appointment() {
    }

    public Appointment(int trainerId, int userId, Date date, Time startTime, Time endTime, String remark) {
        this.trainerId = trainerId;
        this.userId = userId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
