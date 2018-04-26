package com.rocketroi.optimizer.runner;

import service.Algorithm;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public class AlgorithmService {

    private static AlgorithmService service;
    private ServiceLoader<Algorithm> loader;

    private AlgorithmService() {
        loader = ServiceLoader.load(Algorithm.class);
    }

    public static synchronized AlgorithmService getInstance() {
        if (service == null) {
            service = new AlgorithmService();
        }
        return service;
    }


    public Double optimize(Double bid) {
        Double bidResult = null;

        try {
            Iterator<Algorithm> algorithms = loader.iterator();
            while (bidResult == null && algorithms.hasNext()) {
                Algorithm d = algorithms.next();
                bidResult = d.optimize(bid);
            }
        } catch (ServiceConfigurationError serviceError) {
            bidResult = null;
            serviceError.printStackTrace();

        }
        return bidResult;
    }


}
