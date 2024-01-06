package com.cgvsu.math.vectors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Vector2fTest {

    @Test
    void testEquals() {
        //обычный случай равенства/неравенства
        Vector2f v = new Vector2f(1.0f, 2.0f);
        float[] fl1 = {1.0f, 2.0f};
        float[] fl2 = {1.0f, 5.0f};
        Vector2f v1 = new Vector2f(fl1);
        Vector2f v2 = new Vector2f(fl2);
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
        float[] fl1 = {1.0f, 2.0f};
        float[] fl2 = {1.0f, 5.0f};
        Vector2f v1 = new Vector2f(fl1);
        Vector2f v2 = new Vector2f(fl2);
        Vector2f expected = v1.sum(v1, v2);
        Vector2f actual = new Vector2f(2.0f, 7.0f);
        boolean flag = expected.equals(actual);
        assertTrue(flag);
    }

    @Test
    void subtract() {
        float[] fl1 = {1.0f, 5.0f};
        float[] fl2 = {1.0f, 2.0f};
        Vector2f v1 = new Vector2f(fl1);
        Vector2f v2 = new Vector2f(fl2);
        Vector2f expected = v1.subtract(v1, v2);
        Vector2f actual = new Vector2f(0.0f, 3.0f);
        boolean flag = expected.equals(actual);
        assertTrue(flag);
    }

    @Test
    void multiplyByScalar() {
        Vector2f v = new Vector2f(2.0f, 4.0f);
        v.multiplyByScalar(2.0f);
        Vector2f actual = new Vector2f(4.0f, 8.0f);
        boolean flag = v.equals(actual);
        assertTrue(flag);
    }

    @Test
    void divideByScalar() {
        //обычный случай
        Vector2f v = new Vector2f(2.0f, 4.0f);
        v.divideByScalar(2.0f);
        Vector2f actual = new Vector2f(1.0f, 2.0f);
        boolean flag = v.equals(actual);
        assertTrue(flag);
        //нулевой скаляр
        v = new Vector2f(2.0f, 4.0f);
        v.divideByScalar(0.0f);
        actual = new Vector2f(2.0f, 4.0f);
        flag = v.equals(actual);
        assertTrue(flag);
    }

    @Test
    void length() {
        Vector2f v = new Vector2f(3.0f, 4.0f);
        float expected = v.length();
        float actual = 5;
        boolean flag = actual == expected;
        assertTrue(flag);
    }

    @Test
    void normalize() {
        //обычный случай
        Vector2f expected = new Vector2f(3.0f, 4.0f);
        expected.normalize();
        Vector2f actual = new Vector2f(0.6f, 0.8f);
        boolean flag = expected.equals(actual);
        assertTrue(flag);
        //нулевая длина
        expected = new Vector2f(0.0f, 0.0f);
        expected.normalize();
        actual = new Vector2f(0.0f, 0.0f);
        flag = expected.equals(actual);
        assertTrue(flag);
    }

    @Test
    void scalarMultiplication() {
        float[] fl1 = {1.0f, 2.0f};
        float[] fl2 = {1.0f, 5.0f};
        Vector2f expected = new Vector2f(fl1);
        Vector2f v2 = new Vector2f(fl2);
        expected = expected.ScalarMultiplication(v2);
        Vector2f actual = new Vector2f(1.0f, 10.0f);
        boolean flag = expected.equals(actual);
        assertTrue(flag);
    }
}