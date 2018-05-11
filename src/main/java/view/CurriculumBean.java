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
    //    TODO - Fazer tela pra alterar curriculo
    private Curriculum curriculum = new Curriculum();

    public Curriculum getCurriculum() {
        return curriculum;
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

    public void loadFields() {
        System.out.println(UserController.getInstance().getSessionUser().getCurriculum());
        setCurriculum(UserController.getInstance().getSessionUser().getCurriculum());
    }
}
