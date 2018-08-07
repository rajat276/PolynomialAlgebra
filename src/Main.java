import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static String TreeMapToString(TreeMap<Integer,Integer> poly){
        String result="";
        for(Map.Entry<Integer,Integer> entry : poly.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(key !=0) {
                result += "+" + value + "X^" + key;
            }else {
                result +="+" + value;
            }
            //System.out.println(value + "X^" + key);
        }
        result= result.substring(1);
        result=result.replaceAll("\\+-","-");
        System.out.println(result);
        return result;
    }

    public static TreeMap<Integer,Integer> StringToTreeMap(String poly){
        TreeMap<Integer,Integer> treeMap= new TreeMap<>();
        String removeSpace=poly.replaceAll("\\s+","");
        String preProcess= removeSpace.replaceAll("-","\\+-");
        String[] splitAtPlus= preProcess.split("\\+");
        for(String s: splitAtPlus){
            if(s.equals("")){
                continue;
            }
            String[] split= s.split("X");
            int coefficient= Integer.parseInt(split[0]);
            int power=0;
            if(split.length > 1) {
                power = Integer.parseInt(split[1].replaceAll("\\^", ""));
            }
            //System.out.println(coefficient + ":" +power);
            if(treeMap.containsKey(power)){
                treeMap.put(power, treeMap.get(power)+ coefficient);
            }else {
                treeMap.put(power, coefficient);
            }
        }
        System.out.println(treeMap);
        return treeMap;
    }
    public static void main(String[] args){
        /*Scanner scanner= new Scanner(System.in);
        System.out.println("Enter 1 st polynomial:");
        String A = scanner.nextLine();
        System.out.println("Enter 2 nd polynomial:");
        String B = scanner.nextLine();
        System.out.println("Addition: Press 1\nSubstraction: Press 2\nMultiplication: Press 3\n");
        int operation = scanner.nextInt();*/
        String A="3X^2 + 4X^5 + 7 ";
        String B="-2X^5 + 4X^7 -8";
        TreeMapToString(StringToTreeMap(A));
        TreeMapToString(StringToTreeMap(B));

    }
}
