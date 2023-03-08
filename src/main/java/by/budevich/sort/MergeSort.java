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

        int leftSideIndex = 0, rightSideIndex = 0;

        while (leftSideIndex < leftSide.size() && rightSideIndex < rightSide.size()) {
            if (comparator.compare(leftSide.get(leftSideIndex), rightSide.get(rightSideIndex)) > 0) {
                result.add(rightSide.get(rightSideIndex));
                rightSideIndex++;
                continue;
            }
            if (comparator.compare(leftSide.get(leftSideIndex), rightSide.get(rightSideIndex)) < 0) {
                result.add(leftSide.get(leftSideIndex));
                leftSideIndex++;
                continue;
            }
            result.add(leftSide.get(leftSideIndex));
            result.add(rightSide.get(rightSideIndex));
            leftSideIndex++;
            rightSideIndex++;
        }

        if (leftSideIndex == leftSide.size()) {
            result.addAll(rightSide.subList(rightSideIndex, rightSide.size()));
        }
        if (rightSideIndex == rightSide.size()) {
            result.addAll(leftSide.subList(leftSideIndex, leftSide.size()));
        }

        return result;
    }
}
