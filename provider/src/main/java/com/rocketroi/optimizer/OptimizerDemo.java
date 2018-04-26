package com.rocketroi.optimizer;

import com.rocketroi.optimizer.provider.AlgorithmService;

public class OptimizerDemo {

    public static void main(String[] args) {
        AlgorithmService algorithmService = AlgorithmService.getInstance();
        System.out.println(algorithmService.optimize(12D));
    }
}
