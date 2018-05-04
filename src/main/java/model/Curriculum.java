package model;

import java.util.List;

public class Curriculum {

    private int id;
    private List<String> formation;
    private List<String> experience;

    public Curriculum(List<String> formation, List<String> experience) {
        this.formation = formation;
        this.experience = experience;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getFormation() {
        return formation;
    }

    public void setFormation(List<String> formation) {
        this.formation = formation;
    }

    public List<String> getExperience() {
        return experience;
    }

    public void setExperience(List<String> experience) {
        this.experience = experience;
    }
}
