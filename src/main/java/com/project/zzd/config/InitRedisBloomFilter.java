package com.project.zzd.config;

import com.project.zzd.dao.FaultQueryDao;
import io.rebloom.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitRedisBloomFilter implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    FaultQueryDao faultQueryDao;

    @Autowired
    Client reBloomClient;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<String> carBrands = faultQueryDao.getDistinctCarBrand();
        if (!carBrands.isEmpty())
            reBloomClient.addMulti("carBrand", carBrands.stream().toArray(String[]::new));
        List<String> carModels = faultQueryDao.getDistinctCarModel();
        if (!carModels.isEmpty())
            reBloomClient.addMulti("carModel", carModels.stream().toArray(String[]::new));
        List<String> carTypes = faultQueryDao.getDistinctCarType();
        if (!carTypes.isEmpty())
            reBloomClient.addMulti("carType", carTypes.stream().toArray(String[]::new));
    }
}
