package builder;

import service.AlgorithmLibrary;

import java.util.SortedMap;
import java.util.TreeMap;

public class RRAlgorithms implements AlgorithmLibrary {

    private SortedMap<String, Double> map;

    public RRAlgorithms() {
        map = new TreeMap<>();
        map.put(
                "v2",
                2D);
        map.put(
                "v3",
                3D);
    }

    @Override
    public Double optimize(String algorithm, Double bid) {
        return map.get(algorithm) != null ? map.get(algorithm) * bid: null;
    }
}
