package controller;

import dao.DaoFactory;
import dao.UserDaoInterface;
import model.User;

import java.util.ArrayList;

public class UserController {
    private static UserController instance;
    private UserDaoInterface userDaoInterface = DaoFactory.getUserDaoInterface();
    private User sessionUser;

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    public User getSessionUser() {
        if (sessionUser == null) {
            sessionUser = new User();
        }
        return sessionUser;
    }

    public void setSessionUser(User sessionUser) {
        this.sessionUser = sessionUser;
    }

    public UserDaoInterface getUserDaoInterface() {
        return userDaoInterface;
    }

    public void save(User user) throws Exception {
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new Exception("O nome é obrigatório!");
        }
        if (user.getCpf() < 11 || user.getCpf() == 0) {
            throw new Exception("O cpf é obrigatório!");
        }
        if (user.getLogin() == null || user.getLogin().trim().isEmpty()) {
            throw new Exception("O login é obrigatório!");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new Exception("A senha é obrigatória!");
        }
        if (user.getId() == 0) {
            userDaoInterface.save(user);
        } else {
            userDaoInterface.update();
        }
    }

    public ArrayList<User> listAll() {
        ArrayList<User> users = (ArrayList<User>) userDaoInterface.findAll();
        return users;
    }

    public User authenticateLogin(String login, String password) throws Exception {
        if (!login.isEmpty() && !password.isEmpty()) {
            User user = userDaoInterface.authenticate(login, password);
            if (user != null) {
                return user;
            } else {
                throw new Exception("Login ou senha incorretos");
            }
        } else {
            throw new Exception("Os campos login e senha devem ser preenchidos");
        }
    }

    public boolean hasCurriculum() {
        if (getSessionUser().getCurriculum() != null) {
            return true;
        }
        return false;
    }

    public boolean hasJobOp() {
        if (getSessionUser().getJobOpportunity() != null) {
            return true;
        }
        return false;
    }
}
