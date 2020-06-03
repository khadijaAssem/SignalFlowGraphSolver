package sample.Utilities;

import javafx.util.Pair;
import sample.Elements.CompletePath;
import sample.Elements.Path;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class CalculateNumerator {
    private static Map<CompletePath, Set<CompletePath>> paths = new HashMap<>();
//    private static Map<Pair<String,Stack<Path>>,Set<Pair<String,Stack<Path>>>> loops = new HashMap<>();

    public CalculateNumerator(){
        paths = NonIntersecting.getNonIntersectingLPs();
        System.out.println("From Calculate Numerator "+paths.size());
    }
    public double Calculate(){
        CalculateValuesNumbers calc = new CalculateValuesNumbers();
        System.out.println("Calculating Numerator");
        double sum = 0;
        for (Map.Entry<CompletePath, Set<CompletePath>> entry : paths.entrySet()){
            sum+=(entry.getKey().getValue()*calc.delta(entry.getValue()));
        }
        return sum;
    }
    public String CalculateSting(){
        CalculateValuesStrings calc = new CalculateValuesStrings();
        String res = "";
        for (Map.Entry<CompletePath, Set<CompletePath>> entry : paths.entrySet()){
            res = res.concat("("+entry.getKey().getStringValue()+"*"+calc.delta(entry.getValue())+")+");
        }
        if(res.length()!=0)
            res = res.substring(0,res.length()-1);
        return res;
    }
}
