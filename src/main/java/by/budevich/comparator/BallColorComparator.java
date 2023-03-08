package by.budevich.comparator;

import by.budevich.entity.Ball;
import by.budevich.repo.DataResource;

import java.util.List;

public class BallColorComparator implements ResourceBasedComparator<Ball, String> {
    private DataResource<String> ballColorDataResource;

    public BallColorComparator(DataResource<String> ballColorResource) {
        this.ballColorDataResource = ballColorResource;
    }

    @Override
    public int compare(Ball o1, Ball o2) {
        List<String> colorValue = ballColorDataResource.fetchData();
        int o1Index = colorValue.indexOf(o1.getColor());
        int o2Index = colorValue.indexOf(o2.getColor());

        return (o1Index < 0) || (o2Index < 0) ?
                Integer.compare(o2Index, o1Index) :
                Integer.compare(o1Index, o2Index);
    }

    @Override
    public DataResource<String> getResource() {
        return ballColorDataResource;
    }

    @Override
    public void setResource(DataResource<String> resource) {
        this.ballColorDataResource = resource;
    }
}
