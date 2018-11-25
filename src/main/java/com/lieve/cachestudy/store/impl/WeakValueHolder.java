package com.lieve.cachestudy.store.impl;
/**
 * @version 1.0
 * @author <a> href="mailto:sunlijiang@didichuxing.com">sunlijiang</a>
 * @since 2018/11/25 上午12:10
 */

import com.lieve.cachestudy.store.ValueHolder;
import java.lang.invoke.MethodHandles;
import java.lang.ref.WeakReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 弱引用实现
 * @param <V>
 */
public class WeakValueHolder<V> implements ValueHolder<V> {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

    /**
     *
     * @param value
     */
    public WeakValueHolder(V value) {
        this.v = new WeakReference<V>(value);
    }

    private WeakReference<V> v;

    @Override
    public V value() {
        return this.v.get();
    }

}


