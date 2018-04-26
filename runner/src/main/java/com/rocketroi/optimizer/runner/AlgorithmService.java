package com.rocketroi.optimizer.runner;

import service.AlgorithmLibrary;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public class AlgorithmService {

    private static AlgorithmService service;
    private ServiceLoader<AlgorithmLibrary> loader;

    private AlgorithmService() {
        loader = ServiceLoader.load(AlgorithmLibrary.class);
    }

    public static synchronized AlgorithmService getInstance() {
        if (service == null) {
            service = new AlgorithmService();
        }
        return service;
    }


    public Double optimize(String algorithm, Double bid) {
        Double optimizeResult = null;

        try {
            Iterator<AlgorithmLibrary> algorithms = loader.iterator();
            while (optimizeResult == null && algorithms.hasNext()) {
                AlgorithmLibrary d = algorithms.next();
                optimizeResult = d.optimize(algorithm, bid);
            }
        } catch (ServiceConfigurationError serviceError) {
            optimizeResult = null;
            serviceError.printStackTrace();

        }
        return optimizeResult;
    }


}
