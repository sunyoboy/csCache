package com.lieve.cachestudy.store.impl;

import com.lieve.cachestudy.store.DataStore;
import com.lieve.cachestudy.store.StoreAccessException;
import com.lieve.cachestudy.store.ValueHolder;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class BasicDataStore<K, V> implements DataStore<K, V> {

    ConcurrentMap<K, ValueHolder<V>> map = new ConcurrentHashMap<K, ValueHolder<V>>();

    @Override
    public ValueHolder<V> get(K key) throws StoreAccessException {
        return map.get(key);
    }

    @Override
    public PutStatus put(K key, V value) throws StoreAccessException {
        ValueHolder<V> v = new BasicValueHolder<V>(value);
        map.put(key, v);
        return PutStatus.PUT;
    }

    @Override
    public ValueHolder<V> remove(K key) throws StoreAccessException {
        return map.remove(key);
    }

    @Override
    public void clear() throws StoreAccessException {
        map.clear();
    }
}
