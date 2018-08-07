import java.nio.channels.MulticastChannel;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main extends Multiplication{
    public static String TreeMapToString(TreeMap<Integer,Integer> poly){
        return "";
    }

    public static TreeMap<Integer,Integer> StringToTreeMap(String poly){
        return new TreeMap<>();
    }
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter 1 st polynomial:");
        String A = scanner.nextLine();
        System.out.println("Enter 2 nd polynomial:");
        String B = scanner.nextLine();

        Multiplication m = new Multiplication();
        Map< Integer, Integer> X= new TreeMap<Integer, Integer>();
        Map< Integer, Integer> Y= new TreeMap<Integer, Integer>();

        X.put(2, 1);
        X.put(1, 1);
        Y.put(2, 4);
        Y.put(1, -7);
        Y.put(0, 5);

        m.multiply(X,Y);


    }
}
