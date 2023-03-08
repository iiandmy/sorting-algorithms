package by.budevich.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuickSort<T> implements Sort<T> {
    @Override
    public void sort(List<T> collection, Comparator<T> comparator) {
        if (collection.size() <= 1) {
            return;
        }
        int partitionIndex = partition(collection, comparator);
        sort(collection.subList(0, partitionIndex), comparator);
        sort(collection.subList(partitionIndex + 1, collection.size()), comparator);
    }

    public int partition(List<T> collection, Comparator<T> comparator) {
        int partitionIndex = 0;
        T pivot = collection.get(collection.size() - 1);

        for (int i = 0; i < collection.size(); i++) {
            if (comparator.compare(collection.get(i), pivot) >= 0) {
                continue;
            }
            Collections.swap(collection, partitionIndex, i);
            partitionIndex++;
        }

        Collections.swap(collection, partitionIndex, collection.size() - 1);

        return partitionIndex;
    }
}
