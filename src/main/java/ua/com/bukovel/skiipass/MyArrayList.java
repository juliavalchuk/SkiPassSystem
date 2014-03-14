package ua.com.bukovel.skiipass;

/**
 * Created by julia
 */
public class MyArrayList<E, T> {
    private  T[] list;
    private  E[] keys;
    private  int  numElements;

    public MyArrayList(){
        list = (T[])new Object[1];
        keys = (E[])new Object[1];
        numElements = 0;
    }


    public int size(){
        return numElements;
    }

    public T get(E key){
        int index = getKeyIndex(key);

        if(index >= 0) {
            return list[index];
        }
        return null;
    }

    public T set(E key, T newValue){

        int index = getKeyIndex(key);

        if (index < 0){
            return null;
        }

        T oldValue = list[index];
        list[index] = newValue;
        return oldValue;
    }

    public E getKey(T target){
        int index = -1;

        for(int i = 0; i < numElements; i++)
            if(list[i].equals(target)){
                index = i;
            }
        if(index < 0){
            return null;
        }
        return keys[index];
    }

    public  void doubleLength(){
        T[] newarrayl = (T[])new Object[list.length * 2];
        E[] newarrayk = (E[])new Object[list.length * 2];

        for (int i = 0; i < numElements; i++) {
            newarrayl[i] = list[i];
            newarrayk[i] = keys[i];
        }
        list = newarrayl;
        keys = newarrayk;

        //taking advantage of Array Class in Java
        //list = Arrays.copyOf(list, list.length * 2);
    }

    public  void clear(){
        list = null;
        keys = null;
        numElements = 0;
    }

    public T remove(E key){
        int index = getKeyIndex(key);

        T temp = list[index];
        for(int i = index; i < numElements-1; ++i) {
            list[i] = list[i + 1];
            keys[i] = keys[i + 1];
        }
        numElements--;
        if (index <0){
            return null;
        }
        return temp;
    }


//
//    public boolean add(T item){
//        if(numElements == list.length)
//            doubleLength();
//
//        list[numElements] = item;
//        numElements++;
//        return true;
//    }

    public void add(E key, T item){
        if(numElements == list.length)
            doubleLength();
        list[numElements] = item;
        keys[numElements++] = key;



    }

    private int getKeyIndex(E key) {
        int index = -1;
        for(int i = 0; i< numElements; ++i) {
            if(keys[i].equals(key)){
                index = i;
                break;
            }
        }
        return index;
    }
}
