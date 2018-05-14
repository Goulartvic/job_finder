package view;

import controller.UserController;
import model.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {
    private String login;
    private String password;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login() {
        FacesContext faces = FacesContext.getCurrentInstance();
        faces.addMessage(null, new FacesMessage("Successful", "deu boa"));
        User userLogin;
        try {
            userLogin = UserController.getInstance().authenticateLogin(login, password);
            UserController.getInstance().setSessionUser(userLogin);
            faces.addMessage(null, new FacesMessage("Successful", "deu boa"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("logged/main.xhtml");
        } catch (Exception e) {
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
//            e.printStackTrace();
        }
    }

    public void registerUser() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("public/registerUser.xhtml");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
