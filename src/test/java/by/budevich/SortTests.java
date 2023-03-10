package by.budevich;

import by.budevich.comparator.BallColorComparator;
import by.budevich.comparator.BallSizeComparator;
import by.budevich.comparator.BallTypeComparator;
import by.budevich.comparator.ResourceBasedComparator;
import by.budevich.entity.Ball;
import by.budevich.repo.ListDataResource;
import by.budevich.repo.DataResource;
import by.budevich.sort.MergeSort;
import by.budevich.sort.QuickSort;
import by.budevich.sort.Sort;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortTests extends TestCase {
    private Sort<Ball> mergeSort;
    private Sort<Ball> quickSort;
    private List<Ball> listToSort;
    private ResourceBasedComparator<Ball, String> comparatorByColor;
    private ResourceBasedComparator<Ball, String> comparatorByType;
    private Comparator<Ball> comparatorBySize;

    public SortTests(String testName )
    {
        super( testName );
    }

    public void setUp() {
        mergeSort = new MergeSort<>();
        quickSort = new QuickSort<>();
        listToSort = new ArrayList<>(List.of(
                new Ball(3, "Foo", "Soccer"),
                new Ball(5, "Red", "Basketball"),
                new Ball(4, "Green", "Baseball"),
                new Ball(6, "Grey", "Volleyball"),
                new Ball(6, "Blue", "Polo"),
                new Ball(6, "Black", "Soccer")
        ));
        DataResource<String> colorDataResource = new ListDataResource(List.of("Green", "Red", "Blue"));
        DataResource<String> typeDataResource = new ListDataResource(List.of("Basketball", "Soccer", "Volleyball"));
        comparatorByColor = new BallColorComparator(colorDataResource);
        comparatorByType = new BallTypeComparator(typeDataResource);
        comparatorBySize = new BallSizeComparator();
    }

    public void testQuickSort() {
        List<Ball> listCopy = new ArrayList<>(listToSort);
        listCopy.sort(comparatorBySize);

        quickSort.sort(listToSort, comparatorBySize);

        assertEquals(
                listCopy.stream()
                        .map(Ball::getSize)
                        .collect(Collectors.toList()),
                listToSort.stream()
                        .map(Ball::getSize)
                        .collect(Collectors.toList())
        );
    }

    public void testMergeSortByColor() {
        List<Ball> listCopy = new ArrayList<>(listToSort);
        listCopy.sort(comparatorByColor);

        mergeSort.sort(listToSort, comparatorByColor);

        assertEquals(listCopy, listToSort);
    }

    public void testMergeSortByType() {
        List<Ball> listCopy = new ArrayList<>(listToSort);
        listCopy.sort(comparatorByType);

        mergeSort.sort(listToSort, comparatorByType);

        assertEquals(listCopy, listToSort);
    }

    public void testMergeSortBySize() {
        List<Ball> listCopy = new ArrayList<>(listToSort);
        listCopy.sort(comparatorBySize);

        mergeSort.sort(listToSort, comparatorBySize);

        assertEquals(listCopy, listToSort);
    }

    public void testEmptyArray() {
        List<Ball> emptyList = new ArrayList<>();

        mergeSort.sort(emptyList, comparatorBySize);
        quickSort.sort(emptyList, comparatorBySize);

        assertEquals(new ArrayList<>(), emptyList);
    }

    public void testOneElArray() {
        List<Ball> list = new ArrayList<>();
        list.add(new Ball());

        mergeSort.sort(list, comparatorBySize);

        assertNotNull(list);
    }

}
