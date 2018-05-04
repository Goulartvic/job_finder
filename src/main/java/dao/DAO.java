package dao;

public interface DAO<T> {

    void save(T t);

    void update();

    void delete(T t);

}