package uk.ac.wlv.groupwork.model;

import javax.persistence.*;

@Entity
@Table(name = "route_points")
public class RoutePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "walk_id")
    private Walk walk;

    @Column(name = "longitude", precision = 10, scale = 8, nullable = false)
    private double longitude;

    @Column(name = "latitude", precision = 10, scale = 8, nullable = false)
    private double latitude;

    @Column(name = "sequence_order", nullable = false)
    private int sequenceOrder;

    public RoutePoint() {
    }

    public RoutePoint(int id, Walk walk, double longitude, double latitude, int sequenceOrder) {
        this.id = id;
        this.walk = walk;
        this.longitude = longitude;
        this.latitude = latitude;
        this.sequenceOrder = sequenceOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Walk getWalk() {
        return walk;
    }

    public void setWalk(Walk walk) {
        this.walk = walk;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getSequenceOrder() {
        return sequenceOrder;
    }

    public void setSequenceOrder(int sequenceOrder) {
        this.sequenceOrder = sequenceOrder;
    }
}
