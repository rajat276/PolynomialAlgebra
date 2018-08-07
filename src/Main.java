
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Main{


    public static void main(String[] args){

        String A="3X^2 + 4X^5 - 8";
        String B="-2X^5 + 4X^7 - 2";

        Polynomial polyA = new Polynomial(A);
        Polynomial polyB = new Polynomial(B);

        System.out.println(Polynomial.add(polyA,polyB));
        System.out.println(Polynomial.subtract(polyA,polyB));
        System.out.println(Polynomial.multiply(polyA,polyB));

    }
}
