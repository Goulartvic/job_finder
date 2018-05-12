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
    private List<JobOpportunity> jobs = new ArrayList<JobOpportunity>();
    private List<TypeOfJob> typesOfJob = new ArrayList<TypeOfJob>();
    private JobOpportunityController controller = new JobOpportunityController();
    private JobOpportunity job = new JobOpportunity();

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadList() {
//        TODO - mostrar mensagem que não tem nenhuma vaga aberta e voltar pra main
        jobs = controller.listOpenjobs();
        typesOfJob = Arrays.asList(TypeOfJob.values());
    }

    public void loadFields() {
        setJob(UserController.getInstance().getSessionUser().getJobOpportunity());
    }

    public void closeJob() {
        try {
            job.setJobStatus(JobStatus.FECHADA);
            controller.save(job);
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadFields();
    }

    public void viewUsersByJob() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listUsersByJob.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addUserInJob(int id) {
        setJob(controller.jobById(id));
        job.getUsers().add(UserController.getInstance().getSessionUser());
        try {
            controller.save(job);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void imprimeDadosTela() {
        System.out.println("id - ");
        System.out.println(job);

    }
}
