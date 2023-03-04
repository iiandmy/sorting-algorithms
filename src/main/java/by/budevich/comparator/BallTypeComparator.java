package by.budevich.comparator;

import by.budevich.entity.Ball;

import java.util.Comparator;

public class BallTypeComparator implements Comparator<Ball> {
    @Override
    public int compare(Ball o1, Ball o2) {
        //TODO
        return o1.getType().compareTo(o2.getType());
    }
}
