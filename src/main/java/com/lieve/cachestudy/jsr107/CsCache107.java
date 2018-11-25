package com.lieve.cachestudy.jsr107;

import com.lieve.cachestudy.CsCache;
import com.lieve.cachestudy.store.impl.LRUDataStore;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Configuration;
import javax.cache.integration.CompletionListener;
import javax.cache.processor.EntryProcessor;
import javax.cache.processor.EntryProcessorException;
import javax.cache.processor.EntryProcessorResult;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 缓存实例  key value
 */
public class CsCache107<K, V> implements Cache<K, V> {
    //    private CsCache<K,V> csCache=new CsCache<K, V>(new BasicDataStore<K, V>());
    private CsCache<K, V> csCache = new CsCache<K, V>(new LRUDataStore<K, V>(2));
    private String cacheName;
    private CsCaching107Manager caching107Manager;
    private Configuration<K, V> configuration;

    private volatile boolean isClosed;

    public CsCache107(String cacheName, CsCaching107Manager caching107Manager, Configuration<K, V> configuration) {
        this.cacheName = cacheName;
        this.caching107Manager = caching107Manager;
        this.configuration = configuration;
        isClosed = false;
    }

    @Override
    public V get(K k) {
        return csCache.get(k);
    }

    @Override
    public void put(K k, V v) {
        csCache.put(k, v);
    }

    @Override
    public void clear() {
        csCache.clear();
    }

    @Override
    public boolean remove(K k) {
        csCache.remove(k);
        return true;
    }

    @Override
    public Map<K, V> getAll(Set<? extends K> set) {
        return null;
    }

    @Override
    public boolean containsKey(K k) {
        return false;
    }

    @Override
    public void loadAll(Set<? extends K> set, boolean b, CompletionListener completionListener) {

    }

    @Override
    public V getAndPut(K k, V v) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {

    }

    @Override
    public boolean putIfAbsent(K k, V v) {
        return false;
    }

    @Override
    public boolean remove(K k, V v) {
        return false;
    }

    @Override
    public V getAndRemove(K k) {
        return null;
    }

    @Override
    public boolean replace(K k, V v, V v1) {
        return false;
    }

    @Override
    public boolean replace(K k, V v) {
        return false;
    }

    @Override
    public V getAndReplace(K k, V v) {
        return null;
    }

    @Override
    public void removeAll(Set<? extends K> set) {

    }

    @Override
    public void removeAll() {

    }

    @Override
    public <C extends Configuration<K, V>> C getConfiguration(Class<C> aClass) {
        return null;
    }

    @Override
    public <T> T invoke(K k, EntryProcessor<K, V, T> entryProcessor, Object... objects) throws EntryProcessorException {
        return null;
    }

    @Override
    public <T> Map<K, EntryProcessorResult<T>> invokeAll(Set<? extends K> set, EntryProcessor<K, V, T> entryProcessor, Object... objects) {
        return null;
    }

    @Override
    public String getName() {
        return cacheName;
    }

    @Override
    public CacheManager getCacheManager() {
        return caching107Manager;
    }

    @Override
    public void close() {

    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }

    @Override
    public void registerCacheEntryListener(CacheEntryListenerConfiguration<K, V> cacheEntryListenerConfiguration) {

    }

    @Override
    public void deregisterCacheEntryListener(CacheEntryListenerConfiguration<K, V> cacheEntryListenerConfiguration) {

    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return null;
    }
}
