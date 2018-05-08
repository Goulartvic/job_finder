package dao;

import model.Curriculum;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CurriculumDaoImp extends GenericHibernateDao<Curriculum> implements CurriculumDao {

    private EntityManager manager;

    public CurriculumDaoImp() {
        manager = ConnectionManager.getEntityManager();
    }

    @Override
    public List<Curriculum> findAll() {
        Query query = manager.createQuery("FROM Curriculum");
        return query.getResultList();
    }
}
