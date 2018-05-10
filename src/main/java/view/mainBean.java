package view;

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

}
