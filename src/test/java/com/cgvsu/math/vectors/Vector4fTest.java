package com.cgvsu.math.vectors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Vector4fTest {

    @Test
    void testEquals() {
        //обычный случай равенства/неравенства
        Vector4f v = new Vector4f(1.0f,2.0f, 3.0f, 4.0f);
        float[] fl1 = {1.0f,2.0f, 3.0f, 4.0f};
        float[] fl2 = {1.0f,2.0f, 3.0f, 5.0f};
        Vector4f v1 = new Vector4f(fl1);
        Vector4f v2 = new Vector4f(fl2);
        boolean flag1 = v.equals(v1);
        boolean flag2 = v.equals(v2);
        assertTrue(flag1);
        assertFalse(flag2);
        //нулевой вектор
        v2 = null;
        flag2 = v.equals(v2);
        assertFalse(flag2);
    }

    @Test
    void sum() {
        float[] fl1 = {1.0f,2.0f, 3.0f, 4.0f};
        float[] fl2 = {1.0f,2.0f, 3.0f, 5.0f};
        Vector4f v1 = new Vector4f(fl1);
        Vector4f v2 = new Vector4f(fl2);
        Vector4f expected = v1.sum(v1,v2);
        Vector4f actual = new Vector4f(2.0f,4.0f,6.0f,9.0f);
        boolean flag = expected.equals(actual);
        assertTrue(flag);
    }

    @Test
    void subtract() {
        float[] fl1 = {1.0f,2.0f, 3.0f, 5.0f};
        float[] fl2 = {1.0f,2.0f, 3.0f, 4.0f};
        Vector4f v1 = new Vector4f(fl1);
        Vector4f v2 = new Vector4f(fl2);
        Vector4f expected = v1.subtract(v1,v2);
        Vector4f actual = new Vector4f(0.0f,0.0f,0.0f,1.0f);
        boolean flag = expected.equals(actual);
        assertTrue(flag);
    }

    @Test
    void multiplyByScalar() {
        Vector4f v = new Vector4f(2.0f, 4.0f, 2.0f,5.0f);
        v.multiplyByScalar(2.0f);
        Vector4f actual = new Vector4f(4.0f,8.0f,4.0f,10.0f);
        boolean flag = v.equals(actual);
        assertTrue(flag);
    }

    @Test
    void divideByScalar() {
        //обычный случай
        Vector4f v = new Vector4f(2.0f, 4.0f, 2.0f,5.0f);
        v.divideByScalar(2.0f);
        Vector4f actual = new Vector4f(1.0f,2.0f,1.0f,2.5f);
        boolean flag = v.equals(actual);
        assertTrue(flag);
        //нулевой скаляр
        v = new Vector4f(2.0f, 4.0f, 2.0f,5.0f);
        v.divideByScalar(0.0f);
        actual = new Vector4f(2.0f, 4.0f, 2.0f,5.0f);
        flag = v.equals(actual);
        assertTrue(flag);
    }

    @Test
    void length() {
        Vector4f v = new Vector4f(2.0f, 4.0f, 2.0f,5.0f);
        float expected = v.length();
        float actual = 7;
        boolean flag = expected == actual;
        assertTrue(flag);
    }

    @Test
    void normalize() {
        //обычный случай
        Vector4f expected = new Vector4f(1.0f, 1.0f, 1.0f,1.0f);
        expected.normalize();
        Vector4f actual = new Vector4f(0.5f,0.5f,0.5f, 0.5f);
        boolean flag = expected.equals(actual);
        assertTrue(flag);
        //нулевая длина
        expected = new Vector4f(0.0f, 0.0f, 0.0f,0.0f);
        expected.normalize();
        actual = new Vector4f(0.0f, 0.0f, 0.0f,0.0f);
        flag = expected.equals(actual);
        assertTrue(flag);
    }

    @Test
    void scalarMultiplication() {
        float[] fl1 = {1.0f,2.0f, 3.0f, 5.0f};
        float[] fl2 = {1.0f,2.0f, 3.0f, 4.0f};
        Vector4f expected = new Vector4f(fl1);
        Vector4f v2 = new Vector4f(fl2);
        expected = expected.ScalarMultiplication(v2);
        Vector4f actual = new Vector4f(1.0f,4.0f,9.0f,20.0f);
        boolean flag = expected.equals(actual);
        assertTrue(flag);
    }
}