package Repository;


import java.util.List;

public interface CrudOperaions <T>{
    List<T> findAll();
    List<T> saveAll(List<T> toSave);
    T save(T toSave);
    T delete(T toDelete);
}
