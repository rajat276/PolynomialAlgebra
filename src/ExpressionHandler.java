import java.util.Map;
import java.util.TreeMap;

import static java.lang.Math.abs;

public class ExpressionHandler {

    public static String mapToExpression(TreeMap<Integer,Integer> poly){
        String result="";
        for(Map.Entry<Integer,Integer> entry : poly.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            String pow,coff;
            if(key!=0){
                if(key==1){
                    pow="X";
                }else {
                    pow="X^"+key;
                }
            }else {
                pow="";
            }
            if(abs(value)!=1){
                coff=value.toString();
            }else{
                if(value<0){
                    coff="-";
                }else {
                    coff="";
                }
            }
            result +="+"+coff+pow;
            //System.out.println(value + "X^" + key);
        }
        result= result.substring(1);
        result=result.replaceAll("\\+-","-");
        System.out.println(result);
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
            int coefficient=1;
            if(split.length==0){
                coefficient=1;
            }else if(split[0].equals("-")){
                coefficient=-1;
            }else {
                coefficient = Integer.parseInt(split[0]);
            }
            int power=0;
            if(split.length > 1) {
                if(split[1].equals("")){
                    power=1;
                }else {
                    power = Integer.parseInt(split[1].replaceAll("\\^", ""));
                }
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
}
