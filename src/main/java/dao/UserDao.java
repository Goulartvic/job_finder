package dao;

import model.User;

import java.util.List;

public interface UserDao extends DAO<User> {
    List<User> findAll();

    List<User> findUserByCPF(String cpf);

    User findById(Long id);

    User authenticate(String login, String password);
}
