package by.budevich.repo;

import java.util.List;

public interface DataResource<T> {
    List<T> fetchData();
}
