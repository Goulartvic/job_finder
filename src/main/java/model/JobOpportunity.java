package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class JobOpportunity {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String company;
    @Column
    private TypeOfJob typeOfJob;
    @Column
    private String schedule;
    @Column
    private String workplace;
    @Column
    private float salary;

    public JobOpportunity() {
    }

    public JobOpportunity(String company, TypeOfJob typeOfJob, String schedule, String workplace, float salary) {
        this.company = company;
        this.typeOfJob = typeOfJob;
        this.schedule = schedule;
        this.workplace = workplace;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public TypeOfJob getTypeOfJob() {
        return typeOfJob;
    }

    public void setTypeOfJob(TypeOfJob typeOfJob) {
        this.typeOfJob = typeOfJob;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
