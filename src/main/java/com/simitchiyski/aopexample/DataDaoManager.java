package com.simitchiyski.aopexample;


import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DataDaoManager implements DataDao {
    private final HashMap<String, String> data;

    public DataDaoManager() {
        data = new HashMap<>(5);
        data.put("key1", "value1");
        data.put("key2", "value2");
        data.put("key3", "value3");
        data.put("key4", "value4");
        data.put("key5", "value5");
    }

    public HashMap<String, String> getData() {
        return data;
    }

    public String get(String key) {
        return data.get(key);
    }
}
