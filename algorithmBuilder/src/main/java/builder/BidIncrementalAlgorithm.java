package builder;

import service.Algorithm;

public class BidIncrementalAlgorithm implements Algorithm {

    @Override
    public Double optimize(Double bid) {
        return bid * 2;
    }
}
