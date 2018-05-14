package dao;


import model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class UserDaoImp extends GenericHibernateDao<User> implements UserDao {

    private EntityManager manager;

    public UserDaoImp() {
        manager = ConnectionManager.getEntityManager();
    }

    @Override
    public List<User> findAll() {
        Query query = manager.createQuery("FROM User");
        return query.getResultList();
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
        Query query = manager.createQuery("FROM User u where u.login=:login and u.password=:password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        try {
            return (User) query.getSingleResult();

        } catch (NoResultException nre) {
            return null;
        }
    }
}
