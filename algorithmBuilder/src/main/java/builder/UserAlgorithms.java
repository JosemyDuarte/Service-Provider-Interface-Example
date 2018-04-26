package builder;

import service.AlgorithmLibrary;

import java.util.SortedMap;
import java.util.TreeMap;

public class UserAlgorithms implements AlgorithmLibrary {

    private SortedMap<String, Double> map;

    public UserAlgorithms() {
        map = new TreeMap<>();
        map.put(
                "v4",
                4D);
        map.put(
                "v5",
                5D);
    }

    @Override
    public Double optimize(String algorithm, Double bid) {
        return map.get(algorithm) * bid;
    }
}
