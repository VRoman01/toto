package repository;

import entity.Entity;
import repository.Specification.Specification;

import java.util.List;

public interface Repository<T extends Entity> {

    T add(T t);
    void remove(T t);
    void update(T t);

    default List<T> query(Specification specification){
        return null;
    };

}
