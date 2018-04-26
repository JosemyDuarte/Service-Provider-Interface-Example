package com.rocketroi.optimizer.provider;

import com.rocketroi.optimizer.provider.spi.Algorithm;

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
        Double definition = null;

        try {
            Iterator<Algorithm> dictionaries = loader.iterator();
            while (definition == null && dictionaries.hasNext()) {
                Algorithm d = dictionaries.next();
                definition = d.optimize(bid);
            }
        } catch (ServiceConfigurationError serviceError) {
            definition = null;
            serviceError.printStackTrace();

        }
        return definition;
    }


}
