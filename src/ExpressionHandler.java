import java.util.Map;
import java.util.TreeMap;

public class ExpressionHandler {

    public static String mapToExpression(TreeMap<Integer,Integer> poly){
        String result="";
        for(Map.Entry<Integer,Integer> entry : poly.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(key !=0) {
                result += "+" + value + "X^" + key;
            }else {
                result +="+" + value;
            }
        }
        result= result.substring(1);
        result=result.replaceAll("\\+-","-");

        return result;
    }

    public static TreeMap<Integer,Integer> expressionToMap(String poly){
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
           if(treeMap.containsKey(power)){
                treeMap.put(power, treeMap.get(power)+ coefficient);
            }else {
                treeMap.put(power, coefficient);
            }
        }

        return treeMap;
    }
}
