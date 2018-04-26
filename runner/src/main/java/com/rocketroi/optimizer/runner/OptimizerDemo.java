package com.rocketroi.optimizer.runner;

public class OptimizerDemo {

    public static void main(String[] args) {
        AlgorithmService algorithmService = AlgorithmService.getInstance();
        System.out.println(algorithmService.optimize("v2", 3D));
    }
}
