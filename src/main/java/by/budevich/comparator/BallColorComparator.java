package by.budevich.comparator;

import by.budevich.entity.Ball;

import java.util.Comparator;

public class BallColorComparator implements Comparator<Ball> {
    @Override
    public int compare(Ball o1, Ball o2) {
        //TODO
        return o1.getColor().compareTo(o2.getColor());
    }
}
