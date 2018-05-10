package view;

import controller.CurriculumController;
import model.Curriculum;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CurriculumBean {
    private Curriculum curriculum;
    private CurriculumController controller = new CurriculumController();

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public void save() {

    }
}
