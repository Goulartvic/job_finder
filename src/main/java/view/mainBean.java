package view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class mainBean implements Serializable {

    public mainBean() {
    }

    public void registerCurriculum() {
        System.out.println("Abre a tela");
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
