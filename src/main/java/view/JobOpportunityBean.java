package view;

import controller.JobOpportunityController;
import controller.UserController;
import model.JobOpportunity;
import model.JobStatus;
import model.TypeOfJob;
import model.User;

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
        this.jobs = controller.listOpenjobs();
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
        FacesContext faces = FacesContext.getCurrentInstance();
        try {
            job.setJobStatus(JobStatus.ABERTA);
            controller.save(job);
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!", ""));
            FacesContext.getCurrentInstance().getExternalContext().redirect("main.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadJobFields() {
        setJob(UserController.getInstance().getSessionUser().getJobOpportunity());
    }

    public void closeJob() {
        try {
            job.setJobStatus(JobStatus.FECHADA);
            controller.save(job);
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadJobFields();
    }

    public void viewUsersByJob() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listUsersByJob.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addUserInJob(int id) {
        FacesContext faces = FacesContext.getCurrentInstance();
        setJob(controller.jobById(id));
//        TODO - verificar se usuario já se cadastrou na vaga
        if (!controller.userInJob(job, UserController.getInstance().getSessionUser().getId())) {
            job.getUsers().add(UserController.getInstance().getSessionUser());
            try {
                controller.save(job);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário já esta inscrito na vaga", ""));
            System.out.println("usuario já esta na vaga");
        }
    }
}
