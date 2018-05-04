package view;

import controller.UserController;
import model.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class UserBean {

    private User userEdit = new User();
    private List<User> userList = new ArrayList<User>();
    private UserController userController = new UserController();
    private User userSelected = new User();
    private String testPass;

    public String save() {
        FacesContext faces = FacesContext.getCurrentInstance().getCurrentInstance();
        if (!userEdit.getPassword().equals(testPass)) {
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas não conferem", ""));
            return "";
        }
        try {
            userController.save(userEdit);
        } catch (Exception e) {
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
            e.printStackTrace();
            return "";
        }
        return "index";
    }
}
