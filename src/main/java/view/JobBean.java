package view;

import controller.JobController;
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
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ViewScoped
public class JobBean implements Serializable {
    private List<JobOpportunity> jobs;
    private List<TypeOfJob> typesOfJob;
    private JobController controller = new JobController();
    private JobOpportunity job = new JobOpportunity();
    private String area;

    public JobBean() {
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void save() {
        FacesContext faces = FacesContext.getCurrentInstance();
        try {
            job.setJobStatus(JobStatus.ABERTA);
            job.setCompany(UserController.getInstance().getSessionUser().getCompany());
            controller.save(job);
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!", ""));
            FacesContext.getCurrentInstance().getExternalContext().redirect("menu.xhtml");
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
            FacesContext.getCurrentInstance().getExternalContext().redirect("menu.xhtml");
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
        if (!controller.userInJob(job, UserController.getInstance().getSessionUser().getId())) {
            job.getUsers().add(UserController.getInstance().getSessionUser());
            try {
                controller.save(job);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário já esta inscrito na vaga", ""));
            System.out.println("Usuário já esta na vaga");
        }
    }

    public void listJobsByArea() {
        try {
            jobs = controller.listJobsByArea(getArea());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listOpenjobs() {
        jobs = controller.listOpenjobs();
    }
}
