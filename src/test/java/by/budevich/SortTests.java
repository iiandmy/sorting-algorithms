package by.budevich;

import by.budevich.comparator.BallColorComparator;
import by.budevich.comparator.BallSizeComparator;
import by.budevich.comparator.BallTypeComparator;
import by.budevich.comparator.RepoBasedComparator;
import by.budevich.entity.Ball;
import by.budevich.repo.RepositoryImpl;
import by.budevich.repo.Repository;
import by.budevich.sort.MergeSort;
import by.budevich.sort.Sort;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortTests extends TestCase {
    private Sort<Ball> mergeSort;
    private List<Ball> listToSort;
    private Repository<String> colorRepository;
    private Repository<String> typeRepository;
    private RepoBasedComparator<Ball> comparatorByColor;
    private RepoBasedComparator<Ball> comparatorByType;
    private Comparator<Ball> comparatorBySize;

    public SortTests(String testName )
    {
        super( testName );
    }

    public void setUp() {
        mergeSort = new MergeSort<>();
        listToSort = new ArrayList<>(List.of(
                new Ball(3, "Foo", "Soccer"),
                new Ball(5, "Red", "Basketball"),
                new Ball(4, "Green", "Baseball"),
                new Ball(6, "Grey", "Volleyball"),
                new Ball(6, "Blue", "Polo"),
                new Ball(6, "Black", "Soccer")
        ));
        colorRepository = new RepositoryImpl(List.of("Green", "Red", "Blue"));
        typeRepository = new RepositoryImpl(List.of("Basketball", "Soccer", "Volleyball"));
        comparatorByColor = new BallColorComparator(colorRepository);
        comparatorByType = new BallTypeComparator(typeRepository);
        comparatorBySize = new BallSizeComparator();
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

        assertEquals(new ArrayList<>(), emptyList);
    }

    public void testOneElArray() {
        List<Ball> list = new ArrayList<>();
        list.add(new Ball(3, "Color", "Type"));

        mergeSort.sort(list, comparatorBySize);

        assertNotNull(list);
    }

}
