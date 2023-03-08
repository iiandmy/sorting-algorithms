package by.budevich.comparator;

import by.budevich.entity.Ball;
import by.budevich.repo.DataResource;

import java.util.List;

public class BallTypeComparator implements ResourceBasedComparator<Ball, String> {
    private DataResource<String> ballTypeDataResource;
    public BallTypeComparator(DataResource<String> ballTypeResource) {
        this.ballTypeDataResource = ballTypeResource;
    }

    @Override
    public int compare(Ball o1, Ball o2) {
        List<String> typeValues = ballTypeDataResource.fetchData();
        int o1Index = typeValues.indexOf(o1.getType());
        int o2Index = typeValues.indexOf(o2.getType());

        return (o1Index < 0) || (o2Index < 0) ?
                Integer.compare(o2Index, o1Index) :
                Integer.compare(o1Index, o2Index);
    }

    @Override
    public DataResource<String> getResource() {
        return ballTypeDataResource;
    }

    @Override
    public void setResource(DataResource<String> resource) {
        this.ballTypeDataResource = resource;
    }
}
