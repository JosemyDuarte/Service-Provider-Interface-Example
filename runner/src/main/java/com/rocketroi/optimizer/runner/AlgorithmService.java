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
        Double bidResult = null;

        try {
            Iterator<AlgorithmLibrary> algorithms = loader.iterator();
            while (bidResult == null && algorithms.hasNext()) {
                AlgorithmLibrary d = algorithms.next();
                bidResult = d.optimize(algorithm, bid);
            }
        } catch (ServiceConfigurationError serviceError) {
            bidResult = null;
            serviceError.printStackTrace();

        }
        return bidResult;
    }


}
