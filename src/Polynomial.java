import java.util.Map;
import java.util.TreeMap;

public class Polynomial {

    private String polynomialExpression ;
    private TreeMap< Integer, Integer> polynomialMap;

    Polynomial (String polynomialExpression){
        this.polynomialExpression = polynomialExpression;
        polynomialMap = ExpressionHandler.expressionToMap(polynomialExpression);
    }

    public static String add (Polynomial A, Polynomial B){

        TreeMap<Integer, Integer> map1 = new TreeMap(A.polynomialMap);
        TreeMap<Integer, Integer> map2 = new TreeMap(B.polynomialMap);

        TreeMap<Integer, Integer> tmp = new TreeMap<Integer, Integer>();
        for(Map.Entry<Integer, Integer>entry: map1.entrySet()){

            int power = entry.getKey();
            int coeff1 = entry.getValue();
            int coeff2 = 0;
            if(map2.containsKey(power)) {
                coeff2 = map2.get(power);
                map2.remove(power);
            }
            coeff1 = coeff2 + coeff1;
            tmp.put(power, coeff1);
            // map1.remove(power);
        }

        for(Map.Entry<Integer, Integer>entry: map2.entrySet()) {
            if(entry.getValue() != 0){
                tmp.put(entry.getKey(), entry.getValue());
            }
        }


        return ExpressionHandler.mapToExpression(tmp);
    }



    public static String subtract (Polynomial A, Polynomial B){

        TreeMap<Integer, Integer> map1 = new TreeMap(A.polynomialMap);
        TreeMap<Integer, Integer> map2 = new TreeMap(B.polynomialMap);

        TreeMap<Integer, Integer>tmp = new TreeMap<Integer, Integer>();

        for(Map.Entry<Integer, Integer>entry: map1.entrySet()){

            int power = entry.getKey();
            int coeff1 = entry.getValue();
            int coeff2 = 0;

            if(map2.containsKey(power)) {
                coeff2 = map2.get(power);
                map2.remove(power);
            }
            coeff1 = coeff1- coeff2;
            tmp.put(power, coeff1);
            // map1.remove(power);
        }

        for(Map.Entry<Integer, Integer>entry: map2.entrySet()) {
            if(entry.getValue() != 0){
                tmp.put(entry.getKey(), -1*entry.getValue());
            }
        }
        return ExpressionHandler.mapToExpression(tmp);
    }

    public static String multiply (Polynomial A, Polynomial B){

        TreeMap<Integer, Integer> map1 = A.polynomialMap;
        TreeMap<Integer, Integer> map2 = B.polynomialMap;
        TreeMap<Integer, Integer> temp = new TreeMap<Integer,Integer>() ;

        for (Map.Entry<Integer,Integer> x : map1.entrySet()){
            for (Map.Entry<Integer,Integer> y : map2.entrySet()){
                int power = x.getKey() + y.getKey();
                int coEff = x.getValue() * y.getValue();

                if(temp.containsKey(power)){
                    temp.put(power, temp.get(power)+ coEff);
                } else {
                    temp.put(power, coEff);
                }

            }
        }

        return ExpressionHandler.mapToExpression(temp);
    }




}
