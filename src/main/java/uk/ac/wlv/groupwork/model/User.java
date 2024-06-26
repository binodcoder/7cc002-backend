package uk.ac.wlv.groupwork.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private String email;

    private String password;

    @Column(name = "institution_email")
    private String institutionEmail;

    private String gender;

    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<WalkParticipant> participatedWalks;

    public User() {
    }

    public User(int id, String name, String email, String password, String institutionEmail, String gender, int age, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.institutionEmail = institutionEmail;
        this.gender = gender;
        this.age = age;
    }

    public User(int id, String name, String email, String password, String institutionEmail, String gender, int age, Role role, List<WalkParticipant> participatedWalks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.institutionEmail = institutionEmail;
        this.gender = gender;
        this.age = age;
        this.role = role;
        this.participatedWalks = participatedWalks;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInstitutionEmail() {
        return institutionEmail;
    }

    public void setInstitutionEmail(String institutionEmail) {
        this.institutionEmail = institutionEmail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<WalkParticipant> getParticipatedWalks() {
        return participatedWalks;
    }

    public void setParticipatedWalks(List<WalkParticipant> participatedWalks) {
        this.participatedWalks = participatedWalks;
    }
}
