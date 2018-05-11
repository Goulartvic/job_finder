package model;

import javax.persistence.*;

@Entity
@Table(name = "curriculums")
public class Curriculum {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String formation;
    @Column
    private String exp;

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

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "id=" + id +
                ", formation='" + formation + '\'' +
                ", experience='" + exp + '\'' +
                '}';
    }
}
