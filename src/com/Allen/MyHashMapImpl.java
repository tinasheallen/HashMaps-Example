package com.Allen;

import java.util.ArrayList;
import java.util.List;


public class MyHashMapImpl<K,V> implements MyHashMap<K, V> {

    private int numBuckets;
    private List<MyHashMap.Bucket<K, V>> list;
    private int size=0;

    MyHashMapImpl(int numBuckets)
    {
        list=new ArrayList<MyHashMap.Bucket<K, V>>();
        MyHashMap.Bucket<K,V> bucket;
        for(int i=0;i<numBuckets;i++)
        {
            bucket=new BucketImpl();
            list.add(bucket);
        }
        this.numBuckets=numBuckets;
    }

    @Override
    public V get(K key) {

        int i=translate(key.hashCode(),numBuckets);
        MyHashMap.Bucket<K,V> bucket=list.get(i);
        for(MyHashMap.Entry<K, V> entry:bucket.getEntries())
        {
            if(entry.getKey().equals(key))
                return entry.getValue();
        }
        return null;
    }

    @Override
    public V put(K key, V value) {

        int i=translate(key.hashCode(),numBuckets);
        MyHashMap.Bucket<K,V> bucket=list.get(i);
        for(MyHashMap.Entry<K, V> entry:bucket.getEntries())
        {
            if(entry.getKey().equals(key))
            {
                V val=((EntryImpl)entry).v;
                ((BucketImpl)bucket).list2.remove(entry);
                ((EntryImpl)entry).v=value;
                ((BucketImpl)bucket).list2.add(entry);
                return val;
            }
        }
        MyHashMap.Entry<K, V> entryy=new EntryImpl();
        ((EntryImpl)entryy).k=key;
        ((EntryImpl)entryy).v=value;
        ((BucketImpl)bucket).list2.add(entryy);
        size++;
        return null;
    }

    @Override
    public V remove(K key) {
        int i=translate(key.hashCode(),numBuckets);
        MyHashMap.Bucket<K,V> bucket=list.get(i);
        for(MyHashMap.Entry<K, V> entry:bucket.getEntries())
        {
            if(entry.getKey()==key)
            {
                V val=((EntryImpl)entry).v;
                ((BucketImpl)bucket).list2.remove(entry);
                size--;
                return val;
            }
        }
        return null;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public List<? extends MyHashMap.Bucket<K, V>> getBuckets() {

        return list;
    }

    public int translate(int hashCode, int size) {
        return Math.abs(hashCode) % size;
    }

    public class EntryImpl implements MyHashMap.Entry<K, V>
    {

        K k;
        V v;
        @Override
        public K getKey() {

            return k;
        }

        @Override
        public V getValue() {

            return v;
        }

    }

    public class BucketImpl implements MyHashMap.Bucket<K, V>
    {

        private List<MyHashMap.Entry<K, V>> list2=new ArrayList<MyHashMap.Entry<K, V>>();

        @Override
        public List<? extends MyHashMap.Entry<K, V>> getEntries() {

            return list2;
        }

    }

}
