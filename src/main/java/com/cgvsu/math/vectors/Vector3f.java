package com.cgvsu.math.vectors;

public class Vector3f implements Vector<Vector3f> {
    private float x, y, z;

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f(float[] values) {
        this.x = values[0];
        this.y = values[1];
        this.z = values[2];
    }

    public boolean equals(Vector3f other) {
        if (other == null) return false;
        return Math.abs(x - other.x) < eps && Math.abs(y - other.y) < eps && Math.abs(z - other.z) < eps;
    }

    public static Vector3f crossProduct(Vector3f v1, Vector3f v2) {
        return new Vector3f(v1.y * v2.z - v1.z * v2.y, v1.z * v2.x - v1.x * v2.z, v1.x * v2.y - v1.y * v2.x);
    }

    @Override
    public Vector3f sum(Vector3f v1, Vector3f v2) {
        return new Vector3f(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    @Override
    public Vector3f subtract(Vector3f v1, Vector3f v2) {
        return new Vector3f(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    @Override
    public void multiplyByScalar(float a) {
        x = x * a;
        y = y * a;
        z = z * a;
    }

    @Override
    public void divideByScalar(float a) {
        if (a!=0) {
            x = x / a;
            y = y / a;
            z = z / a;
        }
    }

    @Override
    public float length() {
        return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    @Override
    public void normalize() {
        float length = this.length();
        if (length!=0 && length != 1) {
            x = x / length;
            y = y / length;
            z = z / length;
        }
    }

    @Override
    public Vector3f ScalarMultiplication(Vector3f v2) {
        return new Vector3f(x * v2.x, y * v2.y, z * v2.z);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }
}
