package view;

import controller.UserController;
import model.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    private List<User> userList = new ArrayList<User>();
    private UserController userController = new UserController();
    private User user = new User();
    private String name;
    private String cpf;
    private String phone;
    private String company;
    private String login;
    private String password;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

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

    public void save() {
        FacesContext faces = FacesContext.getCurrentInstance().getCurrentInstance();
        user = new User();
        user.setName(name);
        user.setCpf(Integer.parseInt(cpf));
        user.setPhone(phone);
        user.setLogin(login);
        user.setPassword(password);
        user.setCompany(company);
        try {
            userController.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
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
