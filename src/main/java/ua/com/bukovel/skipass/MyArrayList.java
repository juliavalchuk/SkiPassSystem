package ua.com.bukovel.skipass;

import java.util.Arrays;

/**
 * Created by julia
 */
public class MyArrayList<E, T> {
    private  T[] values;
    private  E[] keys;
    private  int  numElements;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(){
        clear();
    }

    public MyArrayList(int initialCapacity){
        this();
        resizeCapacity(initialCapacity);
    }

    public int size(){
        return numElements;
    }

    public int capacity(){
        return values.length;
    }

    public T get(E key){
        int index = getKeyIndex(key);

        if(index >= 0) {
            return values[index];
        }
        throw new IllegalArgumentException("Key is not presented");
    }

    public void set(E key, T newValue){
        int index = getKeyIndex(key);

        if (index < 0){
            throw new IllegalArgumentException("Key is not presented");
        }

        values[index] = newValue;
    }

    public E getKey(T target){
        int index = -1;

        for (int i = 0; i < size(); i++) {
            if(values[i].equals(target)){
                index = i;
                break;
            }
        }

        if (index < 0){
            throw new IllegalArgumentException("Value is not presented");
        }

        return keys[index];
    }

    public void clear(){
        values = (T[])new Object[DEFAULT_CAPACITY];
        keys = (E[])new Object[DEFAULT_CAPACITY];
        numElements = 0;
    }

    public boolean remove(E key){
        int index = getKeyIndex(key);

        if (index < 0){
            return false;
        }

        numElements--;

        for(int i = index; i < size(); ++i) {
            values[i] = values[i + 1];
            keys[i] = keys[i + 1];
        }

        if (size() * 3 < capacity())
        {
            resizeCapacity(capacity() / 2);
        }

        return true;
    }

    public void add(E key, T item){
        if(size() == capacity()) {
            resizeCapacity(capacity() * 2);
        }

        values[numElements] = item;
        keys[numElements] = key;

        numElements++;
    }

    private int getKeyIndex(E key) {
        for (int i = 0; i < size(); ++i) {
            if (keys[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    private void resizeCapacity(int newCapacity){
        if (size() > newCapacity) {
            throw new IllegalArgumentException("Capacity cannot be smaller than size");
        }

        values = Arrays.copyOf(values, newCapacity);
        keys = Arrays.copyOf(keys, newCapacity);
    }
}
