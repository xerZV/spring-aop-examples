package com.simitchiyski.aopexample;

import com.simitchiyski.aopexample.annotation.Performance;
import com.simitchiyski.aopexample.annotation.Trace;
import org.springframework.stereotype.Service;

@Service
public class DataServiceManager implements DataService{
    private final DataDaoManager dataDaoManager;

    public DataServiceManager(DataDaoManager dataDaoManager) {
        this.dataDaoManager = dataDaoManager;
    }

    @Trace
    @Performance
    public String getDataByKey(final String key) {
        return this.dataDaoManager.get(key);
    }

    @Override
    public void sayHello() {
        System.out.println("Saying Hello...");
    }
}
