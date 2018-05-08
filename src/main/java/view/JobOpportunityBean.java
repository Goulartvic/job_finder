package view;

import controller.JobOpportunityController;

import javax.faces.context.FacesContext;
import java.util.List;

public class JobOpportunityBean {
    private List<JobOpportunityBean> jobs;
    private JobOpportunityController controller = new JobOpportunityController();
    private JobOpportunityBean jobOpportunity = new JobOpportunityBean();

    public void save() {
        FacesContext faces = FacesContext.getCurrentInstance().getCurrentInstance();
//        controller.save(jobOpportunity);
    }
}
