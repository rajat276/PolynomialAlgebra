
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Main {


    public static void main(String[] args) {

        String A = "X + 2";
        String B = "1 - X";

        Polynomial polyA = new Polynomial(A);
        Polynomial polyB = new Polynomial(B);

        System.out.println(Polynomial.add(polyA, polyB));
        System.out.println(Polynomial.subtract(polyA, polyB));
        System.out.println(Polynomial.multiply(polyA, polyB));
    }
}