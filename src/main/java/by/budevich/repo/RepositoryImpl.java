package by.budevich.repo;

import java.util.List;

public class RepositoryImpl implements Repository<String> {
    private List<String> availableValues;

    public RepositoryImpl(List<String> availableValues) {
        this.availableValues = availableValues;
    }

    @Override
    public void addItemToList(String item) {
        if (availableValues.contains(item)) return;
        availableValues.add(item);
    }

    @Override
    public void removeItemFromList(String item) {
        availableValues.remove(item);
    }

    @Override
    public List<String> fetchData() {
        return availableValues;
    }
}
