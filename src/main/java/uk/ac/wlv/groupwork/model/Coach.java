package uk.ac.wlv.groupwork.model;

import javax.persistence.*;

@Entity
@Table(name = "coach")
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "user_id")
    private Integer userId;

    private String specification;

    // Constructors, getters, and setters
    public Coach() {
    }

    public Coach(String name, Integer userId, String specification) {
        this.name = name;
        this.userId = userId;
        this.specification = specification;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}
