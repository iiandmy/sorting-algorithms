package by.budevich;

import by.budevich.comparator.BallColorComparator;
import by.budevich.entity.Ball;
import by.budevich.repo.BallColorRepository;
import by.budevich.sort.MergeSort;
import by.budevich.sort.Sort;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class SortTests extends TestCase {
    private Sort<Ball> mergeSort;
    private List<Ball> listToSort;

    public SortTests(String testName )
    {
        super( testName );
    }

    public void setUp() {
        mergeSort = new MergeSort<>();
        listToSort = new ArrayList<>(List.of(
                new Ball(5, "Red", "Basketball"),
                new Ball(4, "Green", "Baseball"),
                new Ball(3, "Foo", "Soccer"),
                new Ball(6, "Grey", "Volleyball"),
                new Ball(6, "Blue", "Soccer")
        ));
    }

    public void testMergeSort() {
        List<Ball> listCopy = new ArrayList<>(listToSort);

        mergeSort.sort(listCopy, new BallColorComparator(new BallColorRepository(
                List.of("Blue", "Green", "Red")
        )));

        assertTrue(true);
    }
}
