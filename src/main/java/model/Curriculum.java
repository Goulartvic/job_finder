package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "curriculums")
public class Curriculum {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String formation;
    @Column
    private String experience;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
