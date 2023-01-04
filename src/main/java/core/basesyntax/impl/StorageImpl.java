package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private int currentSize;
    private K[] keyArray = (K[]) new Object[MAX_ARRAY_SIZE];
    private V[] valueArray = (V[]) new Object[MAX_ARRAY_SIZE];

    @Override
    public void put(K key, V value) {
        if (currentSize < MAX_ARRAY_SIZE) {
            for (int i = 0; i < currentSize; i++) {
                if (Objects.equals(keyArray[i], key)) {
                    valueArray[i] = value;
                    return;
                }
            }
            keyArray[currentSize] = key;
            valueArray[currentSize] = value;
            currentSize++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (Objects.equals(keyArray[i], key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
