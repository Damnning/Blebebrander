package com.cgvsu.math.matrixes;

import com.cgvsu.math.vectors.Vector4f;

public class Matrix4x4 implements Matrix<Matrix4x4, Vector4f> {
    private float a11 = 1;
    private float a12 = 0;
    private float a13 = 0;
    private float a14 = 0;
    private float a21 = 0;
    private float a22 = 1;
    private float a23 = 0;
    private float a24 = 0;
    private float a31 = 0;
    private float a32 = 0;
    private float a33 = 1;
    private float a34 = 0;
    private float a41 = 0;
    private float a42 = 0;
    private float a43 = 0;
    private float a44 = 1;

    public Matrix4x4() {
    }

    public Matrix4x4(float a11, float a12, float a13, float a14, float a21, float a22, float a23, float a24, float a31, float a32, float a33, float a34, float a41, float a42, float a43, float a44) {
        this.a11 = a11;
        this.a12 = a12;
        this.a13 = a13;
        this.a14 = a14;
        this.a21 = a21;
        this.a22 = a22;
        this.a23 = a23;
        this.a24 = a24;
        this.a31 = a31;
        this.a32 = a32;
        this.a33 = a33;
        this.a34 = a34;
        this.a41 = a41;
        this.a42 = a42;
        this.a43 = a43;
        this.a44 = a44;
    }

    @Override
    public void setZero() {
        this.a11 = 0;
        this.a12 = 0;
        this.a13 = 0;
        this.a14 = 0;
        this.a21 = 0;
        this.a22 = 0;
        this.a23 = 0;
        this.a24 = 0;
        this.a31 = 0;
        this.a32 = 0;
        this.a33 = 0;
        this.a34 = 0;
        this.a41 = 0;
        this.a42 = 0;
        this.a43 = 0;
        this.a44 = 0;
    }

    public Float det() {
        Float det = null;
        Matrix3x3 m = new Matrix3x3(a22, a23, a24, a32, a33, a34, a42, a43, a44);
        det += a11 * m.det();
        m = new Matrix3x3(a21, a23, a24, a31, a33, a34, a41, a43, a44);
        det -= a12 * m.det();
        m = new Matrix3x3(a21, a22, a24, a31, a32, a34, a41, a42, a44);
        det += a13 * m.det();
        m = new Matrix3x3(a21, a22, a23, a31, a32, a33, a41, a42, a43);
        det -= a13 * m.det();
        return det;
    }

    @Override
    public Matrix4x4 sum(Matrix4x4 m) {
        if (m == null) return this;
        return new Matrix4x4(
                a11 + m.a11, a12 + m.a12, a13 + m.a13, a14 + m.a14,
                a21 + m.a21, a22 + m.a22, a23 + m.a23, a24 + m.a24,
                a31 + m.a31, a32 + m.a32, a33 + m.a33, a34 + m.a34,
                a41 + m.a41, a42 + m.a42, a43 + m.a43, a44 + m.a44);
    }

    @Override
    public Matrix4x4 subtract(Matrix4x4 m) {
        if (m == null) return this;
        return new Matrix4x4(
                a11 - m.a11, a12 - m.a12, a13 - m.a13, a14 - m.a14,
                a21 - m.a21, a22 - m.a22, a23 - m.a23, a24 - m.a24,
                a31 - m.a31, a32 - m.a32, a33 - m.a33, a34 - m.a34,
                a41 - m.a41, a42 - m.a42, a43 - m.a43, a44 - m.a44);
    }

    @Override
    public Vector4f multiplyByVector(Vector4f v) {
        if (v == null) return null;
        return new Vector4f(
                a11 * v.getX() + a12 * v.getY() + a13 * v.getZ() + a14 * v.getW(),
                a21 * v.getX() + a22 * v.getY() + a23 * v.getZ() + a24 * v.getW(),
                a31 * v.getX() + a32 * v.getY() + a33 * v.getZ() + a34 * v.getW(),
                a41 * v.getX() + a42 * v.getY() + a43 * v.getZ() + a44 * v.getW());
    }

    @Override
    public Matrix4x4 multiplyByMatrix(Matrix4x4 b) {
        if (b == null) return this;
        return new Matrix4x4(
                a11 * b.a11 + a12 * b.a21 + a13 * b.a31 + a14 * b.a41,
                a11 * b.a12 + a12 * b.a22 + a13 * b.a32 + a14 * b.a42,
                a11 * b.a13 + a12 * b.a23 + a13 * b.a33 + a14 * b.a43,
                a11 * b.a14 + a12 * b.a24 + a13 * b.a34 + a14 * b.a44,

                a21 * b.a11 + a22 * b.a21 + a23 * b.a31 + a24 * b.a41, a21 * b.a12 + a22 * b.a22 + a23 * b.a32 + a24 * b.a42, a21 * b.a13 + a22 * b.a23 + a23 * b.a33 + a24 * b.a43, a21 * b.a14 + a22 * b.a24 + a23 * b.a34 + a24 * b.a44,
                a31 * b.a11 + a32 * b.a21 + a33 * b.a31 + a34 * b.a41, a31 * b.a12 + a32 * b.a22 + a33 * b.a32 + a34 * b.a42, a31 * b.a13 + a32 * b.a23 + a33 * b.a33 + a34 * b.a43, a31 * b.a14 + a32 * b.a24 + a33 * b.a34 + a34 * b.a44,
                a41 * b.a11 + a42 * b.a21 + a43 * b.a31 + a44 * b.a41, a41 * b.a12 + a42 * b.a22 + a43 * b.a32 + a44 * b.a42, a41 * b.a13 + a42 * b.a23 + a43 * b.a33 + a44 * b.a43, a41 * b.a14 + a42 * b.a24 + a43 * b.a34 + a44 * b.a44);
    }

    @Override
    public void transpose() {
        try {
            for (int i = 1; i < 4; i++) {
                for (int j = 4; j > i; j--) {
                    float tmp;
                    switch (i) {
                        case 1 -> {
                            if (j == 2) {
                                tmp = a21;
                                a21 = a12;
                                a12 = tmp;
                            }
                            if (j == 3) {
                                tmp = a31;
                                a31 = a13;
                                a13 = tmp;
                            }
                            if (j == 4) {
                                tmp = a41;
                                a41 = a14;
                                a14 = tmp;
                            }
                        }
                        case 2 -> {
                            if (j == 3) {
                                tmp = a32;
                                a32 = a23;
                                a23 = tmp;
                            } else {
                                tmp = a24;
                                a24 = a42;
                                a42 = tmp;
                            }
                        }
                        case 3 -> {
                            tmp = a43;
                            a43 = a34;
                            a34 = tmp;
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Невозможно транспонировать NULL значение");
        }
    }

    @Override
    public float[] getValues() {
        float[] val = new float[16];
        val[0] = a11;
        val[1] = a12;
        val[2] = a13;
        val[3] = a14;
        val[4] = a21;
        val[5] = a22;
        val[6] = a23;
        val[7] = a24;
        val[8] = a31;
        val[9] = a32;
        val[10] = a33;
        val[11] = a34;
        val[12] = a41;
        val[13] = a42;
        val[14] = a43;
        val[15] = a44;
        return val;
    }
}
