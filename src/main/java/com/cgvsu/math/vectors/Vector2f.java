package com.cgvsu.math.vectors;

public class Vector2f implements Vector<Vector2f> {
    private float x, y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f(float[] values) {
        this.x = values[0];
        this.y = values[1];
    }

    public boolean equals(Vector2f other) {
        if (other == null) return false;
        return Math.abs(x - other.x) < eps && Math.abs(y - other.y) < eps;
    }

    @Override
    public Vector2f sum(Vector2f v1, Vector2f v2) {
        return new Vector2f(v1.x + v2.x, v1.y + v2.y);
    }

    @Override
    public Vector2f subtract(Vector2f v1, Vector2f v2) {
        return new Vector2f(v1.x - v2.x, v1.y - v2.y);
    }

    @Override
    public void multiplyByScalar(float a) {
        x = x * a;
        y = y * a;
    }

    @Override
    public void divideByScalar(float a) {
        if (a!=0) {
            x = x / a;
            y = y / a;
        }
    }

    @Override
    public float length() {
        return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    @Override
    public void normalize() {
        float length = this.length();
        if (length != 0 && length != 1) {
            x = x / length;
            y = y / length;
        }
    }

    // dotProduct
    @Override
    public Vector2f ScalarMultiplication(Vector2f v2) {
        return new Vector2f(x * v2.x, y * v2.y);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
