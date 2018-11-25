package com.lieve.cachestudy.store.impl;

import com.lieve.cachestudy.store.ValueHolder;

public class BasicValueHolder<V> implements ValueHolder<V> {

    private final V refValue;

    public BasicValueHolder(final V value) {
        refValue = value;
    }

    @Override
    public V value() {
        return refValue;
    }
}
