package view;

import controller.UserController;
import model.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
    private String login;
    private String password;
    private UserController controller = new UserController();

    private User userSession;

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

    public User getUserSession() {
        return userSession;
    }

    public void setUserSession(User userSession) {
        this.userSession = userSession;
    }

    public void login() {
        FacesContext faces = FacesContext.getCurrentInstance();
        if (controller.authenticateLogin(login, password)) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("public/listAllUsers.xhtml");
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

    public void registerJob() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("public/registerJob.xhtml");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listUsers() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("public/listAllUsers.xhtml");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listJobs() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("public/listAllJobs.xhtml");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
