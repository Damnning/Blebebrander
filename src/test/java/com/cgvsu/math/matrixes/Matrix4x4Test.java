package com.cgvsu.math.matrixes;

import com.cgvsu.math.vectors.Vector4f;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Matrix4x4Test {
    public boolean equals(Matrix4x4 expected, Matrix4x4 actual) {
        float[] exp = expected.getValues();
        float[] act = actual.getValues();
        for (int i=0; i<exp.length; i++) {
            if (exp[i]!=act[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    void setZero() {
        Matrix4x4 expected = new Matrix4x4(
                1.0f, 2.0f, 3.0f, 4.0f,
                5.0f, 6.0f, 7.0f, 8.0f,
                9.0f, 10.0f, 11.0f, 12.0f,
                13.0f, 14.0f, 15.0f, 16.0f);
        expected.setZero();
        Matrix4x4 actual = new Matrix4x4(
                0.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.0f, 0.0f);
        boolean flag = equals(expected,actual);
        assertTrue(flag);
    }

    void det() {
        Matrix4x4 exp = new Matrix4x4(
                1.0f, 2.0f, 3.0f, 4.0f,
                5.0f, 6.0f, 7.0f, 8.0f,
                9.0f, 10.0f, 11.0f, 12.0f,
                13.0f, 14.0f, 15.0f, 16.0f);
        Float expected = null;
        expected = exp.det();
        Float actual = 0.0f;
        boolean flag = (Objects.equals(expected, actual));
        assertTrue(flag);
    }

    @Test
    void sum() {
        Matrix4x4 m1 = new Matrix4x4(
                1.0f, 2.0f, 3.0f, 4.0f,
                5.0f, 6.0f, 7.0f, 8.0f,
                9.0f, 10.0f, 11.0f, 12.0f,
                13.0f, 14.0f, 15.0f, 16.0f);
        Matrix4x4 m2 = new Matrix4x4(
                1.0f, 2.0f, 3.0f, 4.0f,
                5.0f, 6.0f, 7.0f, 8.0f,
                9.0f, 10.0f, 11.0f, 12.0f,
                13.0f, 14.0f, 15.0f, 16.0f);
        Matrix4x4 expected = m1.sum(m2);
        Matrix4x4 actual = new Matrix4x4(
                2.0f, 4.0f, 6.0f, 8.0f,
                10.0f, 12.0f, 14.0f, 16.0f,
                18.0f, 20.0f, 22.0f, 24.0f,
                26.0f, 28.0f, 30.0f, 32.0f);
        boolean flag = equals(expected,actual);
        assertTrue(flag);
        //сумма с null-значением
        m2 = null;
        expected = m1.sum(m2);
        actual = new Matrix4x4(
                1.0f, 2.0f, 3.0f, 4.0f,
                5.0f, 6.0f, 7.0f, 8.0f,
                9.0f, 10.0f, 11.0f, 12.0f,
                13.0f, 14.0f, 15.0f, 16.0f);
        flag = equals(expected,actual);
        assertTrue(flag);
    }

    @Test
    void subtract() {
        Matrix4x4 m1 = new Matrix4x4(
                1.0f, 2.0f, 3.0f, 4.0f,
                5.0f, 6.0f, 7.0f, 8.0f,
                9.0f, 10.0f, 11.0f, 12.0f,
                13.0f, 14.0f, 15.0f, 16.0f);
        Matrix4x4 m2 = new Matrix4x4(
                1.0f, 2.0f, 3.0f, 4.0f,
                5.0f, 6.0f, 7.0f, 8.0f,
                9.0f, 10.0f, 11.0f, 12.0f,
                13.0f, 14.0f, 15.0f, 16.0f);
        Matrix4x4 expected = m1.subtract(m2);
        Matrix4x4 actual = new Matrix4x4(
                0.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.0f, 0.0f);
        boolean flag = equals(expected,actual);
        assertTrue(flag);
        //сумма с null-значением
        m2 = null;
        expected = m1.sum(m2);
        actual = new Matrix4x4(
                1.0f, 2.0f, 3.0f, 4.0f,
                5.0f, 6.0f, 7.0f, 8.0f,
                9.0f, 10.0f, 11.0f, 12.0f,
                13.0f, 14.0f, 15.0f, 16.0f);
        flag = equals(expected,actual);
        assertTrue(flag);
    }

    @Test
    void multiplyByVector() {
        //Обычный случай
        Matrix4x4 m = new Matrix4x4(
                1.0f, 2.0f, 3.0f, 4.0f,
                5.0f, 6.0f, 7.0f, 8.0f,
                9.0f, 10.0f, 11.0f, 12.0f,
                13.0f, 14.0f, 15.0f, 16.0f);
        Vector4f v = new Vector4f(2.0f, 3.0f, 1.0f, 1.0f);
        Vector4f expected = m.multiplyByVector(v);
        Vector4f actual = new Vector4f(15.0f,43.0f,71.0f,99.0f);
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
        Matrix4x4 m1 = new Matrix4x4(
                1.0f, 2.0f, 3.0f, 4.0f,
                5.0f, 6.0f, 7.0f, 8.0f,
                9.0f, 10.0f, 11.0f, 12.0f,
                13.0f, 14.0f, 15.0f, 16.0f);
        Matrix4x4 m2 = new Matrix4x4(
                1.0f, 2.0f, 3.0f, 4.0f,
                5.0f, 6.0f, 7.0f, 8.0f,
                9.0f, 10.0f, 11.0f, 12.0f,
                13.0f, 14.0f, 15.0f, 16.0f);
        Matrix4x4 expected = m1.multiplyByMatrix(m2);
        Matrix4x4 actual = new Matrix4x4(
                90.0f, 100.0f, 110.0f, 120.0f,
                202.0f, 228.0f, 254.0f, 280.0f,
                314.0f, 356.0f, 398.0f, 440.0f,
                426.0f, 484.0f, 542.0f, 600.0f);
        boolean flag = equals(expected,actual);
        assertTrue(flag);
        //деление на null-значение
        m2 = null;
        expected = m1.multiplyByMatrix(m2);
        actual = new Matrix4x4(
                1.0f, 2.0f, 3.0f, 4.0f,
                5.0f, 6.0f, 7.0f, 8.0f,
                9.0f, 10.0f, 11.0f, 12.0f,
                13.0f, 14.0f, 15.0f, 16.0f);
        flag = equals(expected,actual);
        assertTrue(flag);
    }

    @Test
    void transpose() {
        Matrix4x4 expected = new Matrix4x4(
                1.0f, 2.0f, 3.0f, 4.0f,
                5.0f, 6.0f, 7.0f, 8.0f,
                9.0f, 10.0f, 11.0f, 12.0f,
                13.0f, 14.0f, 15.0f, 16.0f);
        expected.transpose();
        Matrix4x4 actual = new Matrix4x4(
                1.0f, 5.0f, 9.0f, 13.0f,
                2.0f, 6.0f, 10.0f, 14.0f,
                3.0f, 7.0f, 11.0f, 15.0f,
                4.0f, 8.0f, 12.0f, 16.0f);
        boolean flag = equals(expected,actual);
        assertTrue(flag);
    }
}