package by.budevich.comparator;

import by.budevich.entity.Ball;

import java.util.Comparator;

public class BallSizeComparator implements Comparator<Ball> {
    @Override
    public int compare(Ball o1, Ball o2) {
        return Integer.compare(o1.getSize(), o2.getSize());
    }
}
