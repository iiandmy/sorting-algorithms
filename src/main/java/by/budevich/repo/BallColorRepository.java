package by.budevich.repo;

import java.util.List;

public class BallColorRepository implements Repository<String> {
    private List<String> availableColors;

    public BallColorRepository(List<String> availableColors) {
        this.availableColors = availableColors;
    }

    @Override
    public void addItemToList(String item) {
        if (availableColors.contains(item)) return;
        availableColors.add(item);
    }

    @Override
    public void removeItemFromList(String item) {
        availableColors.remove(item);
    }

    @Override
    public List<String> fetchData() {
        return availableColors;
    }
}
