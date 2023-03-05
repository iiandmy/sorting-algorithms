package by.budevich.repo;

import java.util.List;

public interface Repository<T> {
    List<T> fetchData();
    void addItemToList(T item);
    void removeItemFromList(T item);
}
