package dao;

import model.Curriculum;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CurriculumDao extends GenericHibernateDao<Curriculum> implements CurriculumDaoInterface {

    private EntityManager manager;

    public CurriculumDao() {
        manager = Connection.getEntityManager();
    }

    @Override
    public List<Curriculum> findAll() {
        Query query = manager.createQuery("FROM Curriculum");
        return query.getResultList();
    }

    @Override
    public Curriculum findById(int id) {
        Query query = manager.createQuery("From Curriculum c where c.id=:id");
        return null;
    }
}
