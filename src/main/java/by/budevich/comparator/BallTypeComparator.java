package by.budevich.comparator;

import by.budevich.entity.Ball;
import by.budevich.repo.Repository;

import java.util.List;

public class BallTypeComparator implements RepoBasedComparator<Ball> {
    private Repository<String> ballTypeRepository;
    public BallTypeComparator(Repository<String> ballTypeRepo) {
        this.ballTypeRepository = ballTypeRepo;
    }

    @Override
    public int compare(Ball o1, Ball o2) {
        List<String> typeValues = ballTypeRepository.fetchData();
        int o1Index = typeValues.indexOf(o1.getType());
        int o2Index = typeValues.indexOf(o2.getType());

        return (o1Index < 0) || (o2Index < 0) ?
                Integer.compare(o2Index, o1Index) :
                Integer.compare(o1Index, o2Index);
    }

    public Repository<String> getBallTypeRepository() {
        return ballTypeRepository;
    }

    public void setBallTypeRepository(Repository<String> ballTypeRepository) {
        this.ballTypeRepository = ballTypeRepository;
    }
}
