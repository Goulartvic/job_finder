package view;

import controller.JobOpportunityController;
import model.JobOpportunity;
import model.TypeOfJob;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ViewScoped
public class JobOpportunityBean implements Serializable {
    private List<JobOpportunity> jobs;
    private List<TypeOfJob> typesOfJob;
    private JobOpportunityController controller = new JobOpportunityController();
    private JobOpportunity job = new JobOpportunity();

    public JobOpportunityBean() {
        this.typesOfJob = Arrays.asList(TypeOfJob.values());
        this.jobs = controller.listAll();
    }

    public List<TypeOfJob> getTypesOfJob() {
        return typesOfJob;
    }

    public JobOpportunity getJob() {
        return job;
    }

    public void setJob(JobOpportunity job) {
        this.job = job;
    }

    public List<JobOpportunity> getJobs() {
        return jobs;
    }

    public void save() {
        FacesContext faces = FacesContext.getCurrentInstance().getCurrentInstance();
        try {
            controller.save(job);
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
