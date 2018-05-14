package view;

import controller.UserController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class mainBean implements Serializable {

    public void registerCurriculum() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("registerCurriculum.xhtml");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void registerJob() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("registerJob.xhtml");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void changeCurriculum() {
        if (UserController.getInstance().hasCurriculum()) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("changeCurriculum.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            registerCurriculum();
        }
    }

    public void viewJobOpportunity() {
        if (UserController.getInstance().hasJobOp()) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("viewJobVagancy.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            registerJob();
        }
    }

    public void listAllJobs() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listAllJobs.xhtml");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
