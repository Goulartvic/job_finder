package controller;

import dao.DaoFactory;
import dao.UserDao;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    UserDao userDao = DaoFactory.getUserDao();
    User sessionUser = new User();

    public User getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(User sessionUser) {
        this.sessionUser = sessionUser;
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
            userDao.save(user);
        } else {
            userDao.update();
        }
    }

    public ArrayList<User> listAll() {
        ArrayList<User> users = (ArrayList<User>) userDao.findAll();
        return users;
    }

    public boolean authenticateLogin(String login, String password) {
        User user = userDao.authenticate(login, password);
        if (user != null) {
            setSessionUser(user);
            return true;
        }
        return false;
    }
}
