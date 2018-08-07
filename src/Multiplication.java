import java.util.*;

public class Multiplication {


    public Map< Integer, Integer> multiply( Map<Integer, Integer> X, Map<Integer, Integer> Y){

        for (Map.Entry<Integer,Integer> x : X.entrySet()){
            Map<Integer, Integer> temp = new TreeMap<Integer,Integer>() ;

            for (Map.Entry<Integer,Integer> y : Y.entrySet()){
                temp.put( x.getKey() + y.getKey(), x.getValue() * y.getValue() );
            }
            Y.clear();
            Y.putAll(temp);
        }

        System.out.println(Y);
        return Y;
    }

}
