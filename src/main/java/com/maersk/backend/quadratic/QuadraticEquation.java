package com.maersk.backend.quadratic;

public class QuadraticEquation {

    public static Roots findRoots(double a, double b, double c) {
        long x1, x2;
        double sqrtVal =  Math.sqrt((b*b)-(4*a*c));
        x1 = (long) ((-b + sqrtVal)/(2*a));
        x2 =  (long) ((b + sqrtVal)/(2*a));
        return new Roots(x1, x2);
    }

    public static void main(String[] args) {
        Roots roots = QuadraticEquation.findRoots(2, 10, 8);
        System.out.println("Roots: " + roots.x1 + ", " + roots.x2);
    }

}
