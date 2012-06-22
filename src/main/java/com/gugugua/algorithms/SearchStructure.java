package com.gugugua.algorithms;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 */
public interface SearchStructure<K extends Comparable<K>, V> {

    public void add(SearchEntry<K, V> entry);

    public void remove(K key);

    public SearchEntry<K, V> get(K key);

}
