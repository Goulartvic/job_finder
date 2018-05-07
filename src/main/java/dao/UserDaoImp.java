package dao;


import model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDaoImp extends GenericHibernateDao<User> implements UserDao {

    private EntityManager manager;

    public UserDaoImp() {
        manager = ConnectionManager.getEntityManager();
    }

    @Override
    public List<User> findAll() {
//        Query query = manager.createNamedQuery("User.findAll");
//        return query.getResultList();
        return null;
    }

    @Override
    public List<User> findUserByCPF(String cpf) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public User authenticate(String login, String password) {
        return null;
    }
}
