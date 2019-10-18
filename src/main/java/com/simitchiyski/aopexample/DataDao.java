package com.simitchiyski.aopexample;

import java.util.HashMap;

public interface DataDao {
    HashMap<String, String> getData();

    String get(String key);
}
