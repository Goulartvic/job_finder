package view;

import controller.UserController;
import model.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class UserBean implements Serializable {

    private List<User> userList;
    private UserController userController = new UserController();
    private User user = new User();

    public UserBean() {
        this.userList = userController.listAll();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void save() {
        FacesContext faces = FacesContext.getCurrentInstance().getCurrentInstance();
        try {
            userController.save(user);
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!", ""));
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listUsers() {
        setUserList(userList = userController.listAll());
    }
}
