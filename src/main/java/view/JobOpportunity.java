package view;

import controller.JobOpportunityController;

import javax.faces.context.FacesContext;
import java.util.List;

public class JobOpportunity {
    private List<JobOpportunity> jobs;
    private JobOpportunityController controller = new JobOpportunityController();
    private JobOpportunity jobOpportunity = new JobOpportunity();

    public void save() {
        FacesContext faces = FacesContext.getCurrentInstance().getCurrentInstance();
//        controller.save(jobOpportunity);
    }
}
