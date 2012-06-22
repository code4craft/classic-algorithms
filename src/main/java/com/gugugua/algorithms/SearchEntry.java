package com.gugugua.algorithms;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 *       用于搜索的项
 */
public class SearchEntry<K extends Comparable<K>, V> {

    private final K key;

    private final V value;

    /**
     * @param key
     * @param value
     */
    public SearchEntry(K key, V value) {
        super();
        if (key == null) {
            throw new IllegalArgumentException("key should not be null");
        }
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SearchEntry [key=" + key + ", value=" + value + "]";
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return key.hashCode() << 16 + value.hashCode();
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SearchEntry) {
            @SuppressWarnings("unchecked")
            SearchEntry<K, V> entry = (SearchEntry<K, V>) obj;
            if (this.key == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.key.equals(entry.getKey())) {
                return false;
            }
            if (this.value == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!this.value.equals(entry.getValue())) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
