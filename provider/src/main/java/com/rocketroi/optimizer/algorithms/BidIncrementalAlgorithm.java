package com.rocketroi.optimizer.algorithms;

import com.rocketroi.optimizer.provider.spi.Algorithm;

public class BidIncrementalAlgorithm implements Algorithm {

    @Override
    public Double optimize(Double bid) {
        return bid *21;
    }
}
