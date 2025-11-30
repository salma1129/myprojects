package org.horizon.demo;

public class Calcul {
    private int a;
    private int b;

    public int getA() { return a; }
    public void setA(int a) { this.a = a; }

    public int getB() { return b; }
    public void setB(int b) { this.b = b; }

    public int addition() { return a + b; }
    public int subtraction() { return a - b; }
    public int multiplication() { return a * b; }
    public double division() {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return (double) a / b;
    }
}
