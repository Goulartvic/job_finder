package view;

import controller.CurriculumController;
import controller.UserController;
import model.Curriculum;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean
@ViewScoped
public class CurriculumBean {
    private Curriculum curriculum = new Curriculum();

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public void saveCurriculum() {
        FacesContext faces = FacesContext.getCurrentInstance();
        CurriculumController.getCurriculumController().save(curriculum);
        faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!", ""));
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("menu.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFields() {
        setCurriculum(UserController.getInstance().getSessionUser().getCurriculum());
    }

    public void backToMenu() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("menu.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
