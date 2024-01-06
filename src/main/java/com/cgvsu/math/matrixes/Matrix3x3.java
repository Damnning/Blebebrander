package com.cgvsu.math.matrixes;

import com.cgvsu.math.vectors.Vector3f;

public class Matrix3x3 implements Matrix<Matrix3x3, Vector3f> {
    private float a11 = 1;
    private float a12 = 0;
    private float a13 = 0;
    private float a21 = 0;
    private float a22 = 1;
    private float a23 = 0;
    private float a31 = 0;
    private float a32 = 0;
    private float a33 = 1;

    private Matrix3x3() {
    }

    public Matrix3x3(float a11, float a12, float a13, float a21, float a22, float a23, float a31, float a32, float a33) {
        this.a11 = a11;
        this.a12 = a12;
        this.a13 = a13;
        this.a21 = a21;
        this.a22 = a22;
        this.a23 = a23;
        this.a31 = a31;
        this.a32 = a32;
        this.a33 = a33;
    }

    @Override
    public void setZero() {
        this.a11 = 0;
        this.a12 = 0;
        this.a13 = 0;
        this.a21 = 0;
        this.a22 = 0;
        this.a23 = 0;
        this.a31 = 0;
        this.a32 = 0;
        this.a33 = 0;
    }

    public Float det() {
        Float det = null;
        det = a11 * a22 * a33 + a12 * a23 * a31 + a13 * a21 * a32 -
                a13 * a22 * a31 - a32 * a23 * a11 - a33 * a21 * a12;
        return det;
    }

    @Override
    public Matrix3x3 sum(Matrix3x3 m) {
        if (m == null) return this;
        return new Matrix3x3(
                a11 + m.a11, a12 + m.a12, a13 + m.a13,
                a21 + m.a21, a22 + m.a22, a23 + m.a23,
                a31 + m.a31, a32 + m.a32, a33 + m.a33);
    }

    @Override
    public Matrix3x3 subtract(Matrix3x3 m) {
        if (m == null) return this;
        return new Matrix3x3(
                a11 - m.a11, a12 - m.a12, a13 - m.a13,
                a21 - m.a21, a22 - m.a22, a23 - m.a23,
                a31 - m.a31, a32 - m.a32, a33 - m.a33);
    }

    @Override
    public Vector3f multiplyByVector(Vector3f v) {
        if (v == null) return null;
        return new Vector3f(
                a11 * v.getX() + a12 * v.getY() + a13 * v.getZ(),
                a21 * v.getX() + a22 * v.getY() + a23 * v.getZ(),
                a31 * v.getX() + a32 * v.getY() + a33 * v.getZ());
    }

    @Override
    public Matrix3x3 multiplyByMatrix(Matrix3x3 b) {
        if (b == null) return this;
        return new Matrix3x3(
                a11 * b.a11 + a12 * b.a21 + a13 * b.a31, a11 * b.a12 + a12 * b.a22 + a13 * b.a32, a11 * b.a13 + a12 * b.a23 + a13 * b.a33,
                a21 * b.a11 + a22 * b.a21 + a23 * b.a31, a21 * b.a12 + a22 * b.a22 + a23 * b.a32, a21 * b.a13 + a22 * b.a23 + a23 * b.a33,
                a31 * b.a11 + a32 * b.a21 + a33 * b.a31, a31 * b.a12 + a32 * b.a22 + a33 * b.a32, a31 * b.a13 + a32 * b.a23 + a33 * b.a33);
    }

    @Override
    public void transpose() {
        for (int i = 1; i < 3; i++) {
            for (int j = 3; j > i; j--) {
                float tmp;
                switch (i) {
                    case 1 -> {
                        if (j == 3) {
                            tmp = a31;
                            a31 = a13;
                            a13 = tmp;
                        } else {
                            tmp = a21;
                            a21 = a12;
                            a12 = tmp;
                        }
                    }
                    case 2 -> {
                        tmp = a23;
                        a23 = a32;
                        a32 = tmp;
                    }
                }
            }
        }
    }

    @Override
    public float[] getValues() {
        float[] val = new float[9];
        val[0] = a11;
        val[1] = a12;
        val[2] = a13;
        val[3] = a21;
        val[4] = a22;
        val[5] = a23;
        val[6] = a31;
        val[7] = a32;
        val[8] = a33;
        return val;
    }
}
