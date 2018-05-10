package view;

import controller.CurriculumController;
import model.Curriculum;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean
@ViewScoped
public class CurriculumBean {
    private Curriculum curriculum;

    public Curriculum getCurriculum() {
        return curriculum = new Curriculum();
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public void save() {
        FacesContext faces = FacesContext.getCurrentInstance();
        System.out.println(curriculum);
        CurriculumController.getInstance().save(curriculum);
        faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!", ""));
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("main.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
