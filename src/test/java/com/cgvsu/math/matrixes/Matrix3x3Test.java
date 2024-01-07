package com.cgvsu.math.matrixes;

import com.cgvsu.math.vectors.Vector3f;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Matrix3x3Test {
    public boolean equals(Matrix3x3 expected, Matrix3x3 actual) {
        float[] exp = expected.getValues();
        float[] act = actual.getValues();
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] != act[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    void setZero() {
        Matrix3x3 expected = new Matrix3x3(
                1.0f, 2.0f, 3.0f,
                4.0f, 5.0f, 6.0f,
                7.0f, 8.0f, 9.0f);
        expected.setZero();
        Matrix3x3 actual = new Matrix3x3(
                0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.0f);
        boolean flag = equals(expected, actual);
        assertTrue(flag);
    }

    @Test
    void det() {
        Matrix3x3 exp = new Matrix3x3(
                1.0f, 2.0f, 3.0f,
                4.0f, 5.0f, 6.0f,
                7.0f, 8.0f, 9.0f);
        Float expected = null;
        expected = exp.det();
        Float actual = 0.0f;
        boolean flag = (Objects.equals(expected, actual));
        assertTrue(flag);
    }

    @Test
    void sum() {
        //обычный случай
        Matrix3x3 m1 = new Matrix3x3(
                1.0f, 2.0f, 3.0f,
                4.0f, 5.0f, 6.0f,
                7.0f, 8.0f, 9.0f);
        Matrix3x3 m2 = new Matrix3x3(
                1.0f, 2.0f, 3.0f,
                4.0f, 5.0f, 6.0f,
                7.0f, 8.0f, 9.0f);
        Matrix3x3 expected = m1.sum(m2);
        Matrix3x3 actual = new Matrix3x3(
                2.0f, 4.0f, 6.0f,
                8.0f, 10.0f, 12.0f,
                14.0f, 16.0f, 18.0f);
        boolean flag = equals(expected, actual);
        assertTrue(flag);
        //сумма с null-значением
        m2 = null;
        expected = m1.sum(m2);
        actual = new Matrix3x3(
                1.0f, 2.0f, 3.0f,
                4.0f, 5.0f, 6.0f,
                7.0f, 8.0f, 9.0f);
        flag = equals(expected, actual);
        assertTrue(flag);
    }

    @Test
    void subtract() {
        //обычный случай
        Matrix3x3 m1 = new Matrix3x3(
                1.0f, 2.0f, 3.0f,
                4.0f, 5.0f, 6.0f,
                7.0f, 8.0f, 9.0f);
        Matrix3x3 m2 = new Matrix3x3(
                1.0f, 2.0f, 3.0f,
                4.0f, 5.0f, 6.0f,
                7.0f, 8.0f, 9.0f);
        Matrix3x3 expected = m1.subtract(m2);
        Matrix3x3 actual = new Matrix3x3(
                0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.0f);
        boolean flag = equals(expected, actual);
        assertTrue(flag);
        //сумма с null-значением
        m2 = null;
        expected = m1.sum(m2);
        actual = new Matrix3x3(
                1.0f, 2.0f, 3.0f,
                4.0f, 5.0f, 6.0f,
                7.0f, 8.0f, 9.0f);
        flag = equals(expected, actual);
        assertTrue(flag);
    }

    @Test
    void multiplyByVector() {
        //обычный случай
        Matrix3x3 m = new Matrix3x3(
                1.0f, 2.0f, 3.0f,
                4.0f, 5.0f, 6.0f,
                7.0f, 8.0f, 9.0f);
        Vector3f v = new Vector3f(2.0f, 3.0f, 1.0f);
        Vector3f expected = m.multiplyByVector(v);
        Vector3f actual = new Vector3f(11.0f, 29.0f, 47.0f);
        boolean flag = expected.equals(actual);
        assertTrue(flag);
        //вектор равен null
        v = null;
        expected = m.multiplyByVector(v);
        actual = null;
        if (expected == null && actual == null) {
            flag = true;
        } else flag = false;
        assertTrue(flag);
    }

    @Test
    void multiplyByMatrix() {
        //обычный случай
        Matrix3x3 m1 = new Matrix3x3(
                1.0f, 4.0f, 3.0f,
                2.0f, 1.0f, 5.0f,
                3.0f, 2.0f, 1.0f);
        Matrix3x3 m2 = new Matrix3x3(
                5.0f, 2.0f, 1.0f,
                4.0f, 3.0f, 2.0f,
                2.0f, 1.0f, 5.0f);
        Matrix3x3 expected = m1.multiplyByMatrix(m2);
        Matrix3x3 actual = new Matrix3x3(
                27.0f, 17.0f, 24.0f,
                24.0f, 12.0f, 29.0f,
                25.0f, 13.0f, 12.0f);
        boolean flag = equals(expected, actual);
        assertTrue(flag);
        //деление на null-значение
        m2 = null;
        expected = m1.multiplyByMatrix(m2);
        actual = new Matrix3x3(
                1.0f, 4.0f, 3.0f,
                2.0f, 1.0f, 5.0f,
                3.0f, 2.0f, 1.0f);
        flag = equals(expected, actual);
        assertTrue(flag);
    }

    @Test
    void transpose() {
        Matrix3x3 expected = new Matrix3x3(
                1.0f, 2.0f, 3.0f,
                4.0f, 5.0f, 6.0f,
                7.0f, 8.0f, 9.0f);
        expected.transpose();
        Matrix3x3 actual = new Matrix3x3(
                1.0f, 4.0f, 7.0f,
                2.0f, 5.0f, 8.0f,
                3.0f, 6.0f, 9.0f);
        boolean flag = equals(expected, actual);
        assertTrue(flag);
    }
}