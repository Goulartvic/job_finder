package view;

import model.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    private String login;
    private String password;

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
        userSession = new User();
        userSession.setLogin("123");
        userSession.setPassword("123");

        System.out.println(userSession.getLogin() + login + userSession.getPassword() + password + "fora do if");
        if (userSession.getLogin().equals(login) && userSession.getPassword().equals(password)) {
            System.out.println(userSession.getLogin() + login + userSession.getPassword() + password + "entrou no if");
        } else {
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ou senha inválido!", ""));
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("public/registerUser.xhtml");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
