package controller;

import dao.DaoFactory;
import dao.UserDao;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    UserDao userDao = DaoFactory.getUserDao();

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
}
