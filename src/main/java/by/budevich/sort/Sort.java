package by.budevich.sort;

import java.util.Comparator;
import java.util.List;

public interface Sort<T> {
    List<T> sort(List<T> collection, Comparator<T> comparator);
}
