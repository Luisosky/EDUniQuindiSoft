package co.edu.uniquindio.uniquindisoft.services;

import java.util.HashMap;
import java.util.Map;

public class SuperCache {
    private Map<String, Map<String, String>> cache= new HashMap<>();

    public void addCache(String key, Map<String, String> value) {
        cache.put(key, value);
    }

    public Map<String, String> getCache(String key) {
        return cache.get(key);
    }
}

