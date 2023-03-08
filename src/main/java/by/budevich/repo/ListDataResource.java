package by.budevich.repo;

import java.util.ArrayList;
import java.util.List;

public class ListDataResource implements DataResource<String> {
    private List<String> availableValues;

    public ListDataResource() {
        this.setAvailableValues(new ArrayList<>());
    }

    public ListDataResource(List<String> availableValues) {
        this.availableValues = availableValues;
    }

    public void setAvailableValues(List<String> availableValues) {
        this.availableValues = availableValues;
    }

    @Override
    public List<String> fetchData() {
        return availableValues;
    }
}
