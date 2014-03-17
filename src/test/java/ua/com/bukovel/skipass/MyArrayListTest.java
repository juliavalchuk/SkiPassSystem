package ua.com.bukovel.skipass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by julia
 */
public class MyArrayListTest {

    @Test
    public void testSizeZero(){
        MyArrayList<Integer, Integer> integerMyArrayList = new MyArrayList<>();
        int actResult = integerMyArrayList.size();
        int expResult = 0;
        assertEquals(expResult, actResult);
    }

    @Test
    public void testSizeOne(){
        MyArrayList<Integer, Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.add(1,1);
        int actResult = integerMyArrayList.size();
        int expResult = 1;
        assertEquals(expResult, actResult);
    }

    @Test
    public void testMyPositiveCapacity(){
        MyArrayList<Integer, Integer> integerMyArrayList = new MyArrayList<>(5);
        int actResult = integerMyArrayList.capacity();
        int expResult = 5;
        assertEquals(expResult, actResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMyNegativeCapacity(){
        MyArrayList<Integer, Integer> integerMyArrayList = new MyArrayList<>(-5);
        int actResult = integerMyArrayList.capacity();
    }

    @Test
    public void testMyZeroCapacity(){
        MyArrayList<Integer, Integer> integerMyArrayList = new MyArrayList<>(0);
        int actResult = integerMyArrayList.capacity();
        int expResult = 0;
        assertEquals(expResult, actResult);
    }

    @Test
    public void testClearArray(){
        MyArrayList<Integer, Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.add(1,1);
        integerMyArrayList.add(0,0);
        integerMyArrayList.clear();
        int actResult = integerMyArrayList.size();
        int expResult = 0;
        assertEquals(expResult, actResult);
    }

    @Test
    public void testClearEmptyArray(){
        MyArrayList<Integer, Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.clear();
        int actResult = integerMyArrayList.size();
        int expResult = 0;
        assertEquals(expResult, actResult);
    }

    @Test
    public void testRemoveArrayValueWithInvalidKey(){
        MyArrayList<Integer, Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.add(1,1);
        integerMyArrayList.add(0, 0);
        boolean actResult = integerMyArrayList.remove(3);
        assertFalse(actResult);
    }

    @Test
    public void testRemoveArrayValueWithValidKey(){
        MyArrayList<Integer, Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.add(1,1);
        integerMyArrayList.add(0, 0);
        boolean actResult = integerMyArrayList.remove(1);
        assertTrue(actResult);
    }

    @Test
    public void testRemoveArrayValueWithValidKeyTwoTimes(){
        MyArrayList<Integer, Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.add(1,1);
        integerMyArrayList.add(0, 0);
        integerMyArrayList.remove(1);
        boolean actResult = integerMyArrayList.remove(1);
        assertFalse(actResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetArrayValueWithInvalidKey(){
        MyArrayList<Integer, Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.add(1,1);
        integerMyArrayList.add(0, 0);
        integerMyArrayList.get(3);
    }

    @Test
    public void testGetArrayValueWithValidKey(){
        MyArrayList<Integer, Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.add(1,2);
        integerMyArrayList.add(0,0);
        int actResult = integerMyArrayList.get(1);
        int expResult = 2;
        assertEquals(expResult, actResult);
    }
      
    @Test(expected = IllegalArgumentException.class)
    public void testSetNewArrayValueWithInvalidKey(){
        MyArrayList<Integer, Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.add(1,1);
        integerMyArrayList.add(0,0);
        integerMyArrayList.set(3, 3);
    }

    @Test
    public void testSetArrayValueWithValidKey(){
        MyArrayList<Integer, Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.add(1,1);
        integerMyArrayList.add(0,0);
        integerMyArrayList.set(1, 3);
        int actResult = integerMyArrayList.get(1);
        int expResult = 3;
        assertEquals(expResult, actResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetArrayKeyWithInvalidValue(){
        MyArrayList<Integer, Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.add(1,1);
        integerMyArrayList.add(0,0);
        integerMyArrayList.getKey(3);
    }

    @Test
    public void testGetArrayKeyWithValidValue(){
        MyArrayList<Integer, Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.add(1,2);
        integerMyArrayList.add(0,0);
        int actResult = integerMyArrayList.getKey(2);
        int expResult = 1;
        assertEquals(expResult, actResult);
    }

}
