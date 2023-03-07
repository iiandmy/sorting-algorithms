package by.budevich;

import by.budevich.comparator.BallColorComparator;
import by.budevich.comparator.BallSizeComparator;
import by.budevich.comparator.BallTypeComparator;
import by.budevich.comparator.RepoBasedComparator;
import by.budevich.entity.Ball;
import by.budevich.repo.RepositoryImpl;
import by.budevich.repo.Repository;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest extends TestCase {
    private Comparator<Ball> sizeComparator;
    private RepoBasedComparator<Ball> typeComparator;
    private RepoBasedComparator<Ball> colorComparator;
    private Repository<String> colorRepo;
    private Repository<String> typeRepo;

    public ComparatorTest(String testName) {
        super(testName);
    }

    protected void setUp() {
        this.colorRepo = new RepositoryImpl(List.of("Green", "Blue", "Red"));
        this.typeRepo = new RepositoryImpl(List.of("Basketball", "Soccer", "Volleyball"));
        this.sizeComparator = new BallSizeComparator();
        this.colorComparator = new BallColorComparator(this.colorRepo);
        this.typeComparator = new BallTypeComparator(this.typeRepo);
    }

    public void testTypeComparator() {
        Ball ball1 = new Ball(4, "Green", "Basketball"); // Priority is 0
        Ball ball2 = new Ball(5, "Blue", "Baseball");    // Not presented in Repo
        Ball ball3 = new Ball(5, "Grey", "Soccer");      // Priority is 1
        Ball ball4 = new Ball(5, "White", "Handball");   // Not presented in Repo

        assertTrue(this.typeComparator.compare(ball1, ball2) < 0);
        assertTrue(this.typeComparator.compare(ball2, ball1) > 0);
        assertTrue(this.typeComparator.compare(ball1, ball3) < 0);
        assertEquals(0, this.typeComparator.compare(ball2, ball4));
    }

    public void testColorComparator() {
        Ball ball1 = new Ball(4, "Green", "Basketball"); // Priority is 0
        Ball ball2 = new Ball(5, "Blue", "Baseball");    // Priority is 1
        Ball ball3 = new Ball(5, "Grey", "Football");    // Not presented in Repo
        Ball ball4 = new Ball(5, "White", "Handball");   // Not presented in Repo

        assertTrue(this.colorComparator.compare(ball1, ball2) < 0);
        assertTrue(this.colorComparator.compare(ball2, ball1) > 0);
        assertTrue(this.colorComparator.compare(ball1, ball3) < 0);
        assertEquals(0, this.colorComparator.compare(ball3, ball4));
    }

    public void testSizeComparator() {
        Ball ball1 = new Ball(4, "Green", "Basketball");
        Ball ball2 = new Ball(5, "Blue", "Baseball");
        Ball ball3 = new Ball(3, "Grey", "Football");

        assertTrue(this.sizeComparator.compare(ball1, ball2) < 0);
        assertTrue(this.sizeComparator.compare(ball1, ball3) > 0);
    }
}
