package dao;

public class GenericHibernateDao<E> implements DAO<E> {

    @Override
    public void save(E e) {
        Connection.getEntityManager().getTransaction().begin();
        Connection.getEntityManager().persist(e);
        Connection.getEntityManager().getTransaction().commit();
    }

    @Override
    public void update() {
        Connection.getEntityManager().getTransaction().begin();
        Connection.getEntityManager().getTransaction().commit();
    }

    @Override
    public void delete(E e) {
        Connection.getEntityManager().getTransaction().begin();
        Connection.getEntityManager().remove(e);
        Connection.getEntityManager().getTransaction().commit();
    }
}
