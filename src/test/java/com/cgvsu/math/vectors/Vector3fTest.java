package com.cgvsu.math.vectors;

import org.junit.jupiter.api.Test;

import static com.cgvsu.math.vectors.Vector3f.crossProduct;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Vector3fTest {

    @Test
    void testEquals() {
        //обычный случай равенства/неравенства
        Vector3f v = new Vector3f(1.0f, 2.0f, 3.0f);
        float[] fl1 = {1.0f, 2.0f, 3.0f};
        float[] fl2 = {1.0f, 2.0f, 5.0f};
        Vector3f v1 = new Vector3f(fl1);
        Vector3f v2 = new Vector3f(fl2);
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
    void testCrossProduct() {
        float[] fl1 = {1.0f, 2.0f, 3.0f};
        float[] fl2 = {1.0f, 2.0f, 5.0f};
        Vector3f v1 = new Vector3f(fl1);
        Vector3f v2 = new Vector3f(fl2);
        Vector3f expected = crossProduct(v1,v2);
        Vector3f actual = new Vector3f(4.0f, -2.0f, 0.0f);
        boolean flag = expected.equals(actual);
        assertTrue(flag);
    }

    @Test
    void sum() {
        float[] fl1 = {1.0f, 2.0f, 3.0f};
        float[] fl2 = {1.0f, 2.0f, 5.0f};
        Vector3f v1 = new Vector3f(fl1);
        Vector3f v2 = new Vector3f(fl2);
        Vector3f expected = v1.sum(v1, v2);
        Vector3f actual = new Vector3f(2.0f, 4.0f, 8.0f);
        boolean flag = expected.equals(actual);
        assertTrue(flag);
    }

    @Test
    void subtract() {
        float[] fl1 = {1.0f, 2.0f, 5.0f};
        float[] fl2 = {1.0f, 2.0f, 3.0f};
        Vector3f v1 = new Vector3f(fl1);
        Vector3f v2 = new Vector3f(fl2);
        Vector3f expected = v1.subtract(v1, v2);
        Vector3f actual = new Vector3f(0.0f, 0.0f, 2.0f);
        boolean flag = expected.equals(actual);
        assertTrue(flag);
    }

    @Test
    void multiplyByScalar() {
        Vector3f v = new Vector3f(2.0f, 4.0f, 2.0f);
        v.multiplyByScalar(2.0f);
        Vector3f actual = new Vector3f(4.0f, 8.0f, 4.0f);
        boolean flag = v.equals(actual);
        assertTrue(flag);
    }

    @Test
    void divideByScalar() {
        //обычный случай
        Vector3f v = new Vector3f(2.0f, 4.0f, 2.0f);
        v.divideByScalar(2.0f);
        Vector3f actual = new Vector3f(1.0f, 2.0f, 1.0f);
        boolean flag = v.equals(actual);
        assertTrue(flag);
        //нулевой скаляр
        v = new Vector3f(2.0f, 4.0f, 2.0f);
        v.divideByScalar(0.0f);
        actual = new Vector3f(2.0f, 4.0f, 2.0f);
        flag = v.equals(actual);
        assertTrue(flag);
    }

    @Test
    void length() {
        Vector3f v = new Vector3f(2.0f, 4.0f, 4.0f);
        float expected = v.length();
        float actual = 6;
        boolean flag = 6 == expected;
        assertTrue(flag);
    }

    @Test
    void normalize() {
        //обычный случай
        Vector3f expected = new Vector3f(25.0f, 0.0f, 0.0f);
        expected.normalize();
        Vector3f actual = new Vector3f(1.0f, 0.0f, 0.0f);
        boolean flag = expected.equals(actual);
        assertTrue(flag);
        //нулевая длина
        expected = new Vector3f(0.0f, 0.0f, 0.0f);
        expected.normalize();
        actual = new Vector3f(0.0f, 0.0f, 0.0f);
        flag = expected.equals(actual);
        assertTrue(flag);
    }

    @Test
    void scalarMultiplication() {
        float[] fl1 = {1.0f, 2.0f, 5.0f};
        float[] fl2 = {1.0f, 2.0f, 3.0f};
        Vector3f expected = new Vector3f(fl1);
        Vector3f v2 = new Vector3f(fl2);
        expected = expected.ScalarMultiplication(v2);
        Vector3f actual = new Vector3f(1.0f, 4.0f, 15.0f);
        boolean flag = expected.equals(actual);
        assertTrue(flag);
    }
}