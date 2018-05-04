package model;


import javax.persistence.Entity;

public class JobOpportunity {
    private int id;
    private String company;
    private TypeOfJob typeOfJob;
    private String schedule;
    private String workplace;
    private float salary;

    public JobOpportunity(String company, TypeOfJob typeOfJob, String schedule, String workplace, float salary) {
        this.company = company;
        this.typeOfJob = typeOfJob;
        this.schedule = schedule;
        this.workplace = workplace;
        this.salary = salary;
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
