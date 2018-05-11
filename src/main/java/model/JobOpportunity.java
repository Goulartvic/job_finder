package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column
    private JobStatus jobStatus;

    @ManyToMany
    @JoinTable(
            name = "curriculums_for_job", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "curriculum_id")
    )
    private List<Curriculum> curriculums = new ArrayList<Curriculum>();

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

    public List<Curriculum> getCurriculums() {
        return curriculums;
    }

    public void setCurriculums(List<Curriculum> curriculums) {
        this.curriculums = curriculums;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    @Override
    public String toString() {
        return "JobOpportunity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", typeOfJob=" + typeOfJob +
                ", schedule='" + schedule + '\'' +
                ", workplace='" + workplace + '\'' +
                ", salary=" + salary +
                ", jobStatus=" + jobStatus +
                ", curriculums=" + curriculums +
                '}';
    }
}
