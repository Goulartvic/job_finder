package view;

import controller.UserController;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
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
        if (UserController.getInstance().authenticateLogin(login, password)) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("logged/main.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ou senha inválido!", ""));
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("public/registerUser.xhtml");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
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
