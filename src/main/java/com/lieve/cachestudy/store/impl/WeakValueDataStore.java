package com.lieve.cachestudy.store.impl;
/**
 * @version 1.0
 * @author <a> href="mailto:sunlijiang@didichuxing.com">sunlijiang</a>
 * @since 2018/11/25 上午12:10
 */

import com.lieve.cachestudy.store.DataStore;
import com.lieve.cachestudy.store.StoreAccessException;
import com.lieve.cachestudy.store.ValueHolder;
import java.lang.invoke.MethodHandles;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeakValueDataStore<K, V> implements DataStore<K, V> {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

    ConcurrentHashMap<K, ValueHolder<V>> map = new ConcurrentHashMap<>();

    @Override
    public ValueHolder<V> get(K key) throws StoreAccessException {
        return map.get(key);
    }

    @Override
    public PutStatus put(K key, V value) throws StoreAccessException {
        ValueHolder<V> v = new WeakValueHolder<V>(value);
        map.put(key,v);
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
