package by.budevich.sort;

import java.util.*;

public class MergeSort<T> implements Sort<T> {
    @Override
    public void sort(List<T> collection, Comparator<T> comparator) {
        if (collection.size() <= 1) {
            return;
        }

        List<T> leftSide = new ArrayList<>(collection.subList(0, collection.size() / 2));
        List<T> rightSide = new ArrayList<>(collection.subList(collection.size() / 2, collection.size()));
        collection.clear();

        sort(leftSide, comparator);
        sort(rightSide, comparator);

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

        if (i == leftSide.size()) {
            result.addAll(rightSide.subList(j, rightSide.size()));
        }
        if (j == rightSide.size()) {
            result.addAll(leftSide.subList(i, leftSide.size()));
        }

        return result;
    }
}
