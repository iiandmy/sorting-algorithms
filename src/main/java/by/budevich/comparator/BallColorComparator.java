package by.budevich.comparator;

import by.budevich.entity.Ball;
import by.budevich.repo.Repository;

import java.util.List;

public class BallColorComparator implements RepoBasedComparator<Ball> {
    private Repository<String> ballColorRepository;

    public BallColorComparator(Repository<String> ballColorRepo) {
        this.ballColorRepository = ballColorRepo;
    }

    @Override
    public int compare(Ball o1, Ball o2) {
        List<String> colorValue = ballColorRepository.fetchData();
        int o1Index = colorValue.indexOf(o1.getColor());
        int o2Index = colorValue.indexOf(o2.getColor());

        return (o1Index < 0) || (o2Index < 0) ?
                Integer.compare(o1Index, o2Index) :
                Integer.compare(o2Index, o1Index);
    }

    public Repository<String> getBallColorRepository() {
        return ballColorRepository;
    }

    public void setBallColorRepository(Repository<String> ballColorRepository) {
        this.ballColorRepository = ballColorRepository;
    }
}
