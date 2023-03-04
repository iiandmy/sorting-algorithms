package by.budevich.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort<T> implements Sort<T> {
    @Override
    public List<T> sort(List<T> collection, Comparator<T> comparator) {
        List<T> result = new ArrayList<>();
        if (collection.size() == 1) {
            result.add(collection.get(0));
            return result;
        }

        List<T> leftSortedPart = sort(collection.subList(0, collection.size() / 2 - 1), comparator);
        List<T> rightSortedPart = sort(collection.subList(collection.size() / 2, collection.size() - 1), comparator);



        return result;
    }
}
