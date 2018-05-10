package controller;

import dao.DaoFactory;
import dao.UserDao;
import model.User;

import java.util.ArrayList;

public class UserController {
    private static UserController instance;
    private UserDao userDao = DaoFactory.getUserDao();
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

    public UserDao getUserDao() {
        return userDao;
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
        System.out.println("usuario não existe");
        return false;
    }
}
