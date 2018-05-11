package view;

import controller.JobOpportunityController;
import controller.UserController;
import model.JobOpportunity;
import model.JobStatus;
import model.TypeOfJob;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
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
            job.setJobStatus(JobStatus.ABERTA);
            controller.save(job);
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadFields() {
        System.out.println(UserController.getInstance().getSessionUser().getJobOpportunity());
        setJob(UserController.getInstance().getSessionUser().getJobOpportunity());
    }

    public void closeJob() {
        job.setJobStatus(JobStatus.FECHADA);
        save();
        loadFields();
    }

    public void viewUsersByJob() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listUsersByJob.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addUserInJob() {
        int id = 0;
        System.out.println("addUser");
        setJob(controller.jobById(id));
        job.getCurriculums().add(UserController.getInstance().getSessionUser().getCurriculum());
        System.out.println(job);
        System.out.println(job.getCurriculums());
        try {
            controller.save(job);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
