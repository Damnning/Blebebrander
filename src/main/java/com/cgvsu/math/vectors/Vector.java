package com.cgvsu.math.vectors;

public interface Vector<T extends Vector> {
    final float eps = 1e-7f;
    public T sum(T value1, T value2);
    public T subtract(T value1, T value2);
    public void multiplyByScalar(float a);
    public void divideByScalar(float a);
    public float length();
    public void normalize();
    public T ScalarMultiplication(T value);
}
