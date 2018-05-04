package dao;

public class GenericHibernateDao<E> implements DAO<E> {

    @Override
    public void save(E e) {
        ConnectionManager.getEntityManager().getTransaction().begin();
        ConnectionManager.getEntityManager().persist(e);
        ConnectionManager.getEntityManager().getTransaction().commit();
    }

    @Override
    public void update() {
        ConnectionManager.getEntityManager().getTransaction().begin();
        ConnectionManager.getEntityManager().getTransaction().commit();
    }

    @Override
    public void delete(E e) {
        ConnectionManager.getEntityManager().getTransaction().begin();
        ConnectionManager.getEntityManager().remove(e);
        ConnectionManager.getEntityManager().getTransaction().commit();
    }
}
