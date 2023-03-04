package by.budevich.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort<T> implements Sort<T> {
    @Override
    public void sort(List<T> collection, Comparator<T> comparator) {
        if (collection.size() == 1) {
            return;
        }

        List<T> leftSide = collection.subList(0, collection.size() / 2);
        List<T> rightSide = collection.subList(collection.size() / 2, collection.size());

        sort(leftSide, comparator);
        sort(rightSide, comparator);

        collection.clear();
        collection.addAll(merge(leftSide, rightSide, comparator));
    }

    private List<T> merge(
            List<T> leftSide,
            List<T> rightSide,
            Comparator<T> comparator
    ) {
        List<T> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < leftSide.size() && j < rightSide.size()) {
            if (comparator.compare(leftSide.get(i), rightSide.get(j)) > 0) {
                result.add(rightSide.get(j));
                j++;
                continue;
            }
            if (comparator.compare(leftSide.get(i), rightSide.get(j)) < 0) {
                result.add(leftSide.get(i));
                i++;
                continue;
            }
            result.add(leftSide.get(i));
            result.add(rightSide.get(j));
            i++;
            j++;
        }

        return result;
    }
}
