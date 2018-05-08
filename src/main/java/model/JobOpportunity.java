package model;

import javax.persistence.*;

@Entity
@Table(name = "job_opportunities")
public class JobOpportunity {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
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

    public JobOpportunity(String name, String company, TypeOfJob typeOfJob, String schedule, String workplace, float salary) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
