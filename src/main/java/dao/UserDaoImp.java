package dao;

import br.ufsc.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDaoImp extends GenericHibernateDao<User> implements UserDao {

    private EntityManager manager;

    public UserDaoImp() {
        manager = ConnectionManager.getEntityManager();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findUserByCPF(String cpf) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User authenticate(String login, String password) {
        return null;
    }
}
