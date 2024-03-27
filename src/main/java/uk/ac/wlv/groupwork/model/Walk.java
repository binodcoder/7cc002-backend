package uk.ac.wlv.groupwork.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "walks")
public class Walk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "proposer_id")
    private Integer proposerId;

    @Column(name = "route_data")
    private String routeData;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "start_location")
    private String startLocation;

    public Walk() {
    }

    public Walk(int id, Integer proposerId, String routeData, Date date, Time startTime, String startLocation) {
        this.id = id;
        this.proposerId = proposerId;
        this.routeData = routeData;
        this.date = date;
        this.startTime = startTime;
        this.startLocation = startLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getProposerId() {
        return proposerId;
    }

    public void setProposerId(Integer proposerId) {
        this.proposerId = proposerId;
    }

    public String getRouteData() {
        return routeData;
    }

    public void setRouteData(String routeData) {
        this.routeData = routeData;
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

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }
}
