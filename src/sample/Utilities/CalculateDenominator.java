package sample.Utilities;

import javafx.util.Pair;
import sample.Elements.CompletePath;
import sample.Elements.Path;

import java.util.*;

public class CalculateDenominator {
    private static Map<CompletePath, Set<CompletePath>> loops = new HashMap<>();
    private CalculateValuesNumbers calc = new CalculateValuesNumbers();

    public CalculateDenominator() {
        loops = NonIntersecting.getNonIntersectingLoops();
    }

    public double Calculate(){
        int sign = -1;
        double delta = 1;
        double allLoops = 0;
        for (Map.Entry<CompletePath, Set<CompletePath>> entry : loops.entrySet()){
            allLoops += entry.getKey().getValue();
            System.out.println(allLoops);
        }
        delta += (sign * allLoops);
        Set<Set<CompletePath>> main = NonIntersecting.getMainNonTouching();
        if(main.size()==0) return delta;
        Iterator<Set<CompletePath>> it = main.iterator();
        Set<CompletePath> set = it.next();
        int size = set.size();
        boolean flag = false;
        while(it.hasNext()||!flag) {
            double sum = 0;
            flag = true;
            System.out.println("Calculating for size "+size);
            while (set.size() == size){
                Iterator<CompletePath> st = set.iterator();
                System.out.println("Calculating in size "+size);
                allLoops = 1;
                while(st.hasNext()){
                    System.out.println("The loop");
                    allLoops *= st.next().getValue();
                }
                sum+=allLoops;
                if(it.hasNext())
                    set = it.next();
                else break;
            }
            sign *= Math.pow(-1, size);
            delta += (sign*-1 * sum);
            if(it.hasNext()) {
                set = it.next();
                size = set.size();
                flag = false;
            }
        }

        return delta;
    }
    public String CalculateSting() {
        String res = "1";
        int sign = -1;
        String allLoops = "";
        for (Map.Entry<CompletePath, Set<CompletePath>> entry : loops.entrySet()){
            allLoops += (entry.getKey().getStringValue() + "+");
            System.out.println("All Loops From Denominator"+allLoops);
        }
        res = res.concat("("+sign +"*"+ allLoops+")");
        Set<Set<CompletePath>> main = NonIntersecting.getMainNonTouching();
        if(main.size()==0) {
            System.out.print("Main size = 0");
            return res;
        }
        Iterator<Set<CompletePath>> it = main.iterator();
        Set<CompletePath> set = it.next();
        int size = set.size();
        boolean flag = false;
        while(it.hasNext()||!flag) {
            flag = true;
            String sum = "";
            System.out.println("Calculating for size "+size);
            while (set.size() == size){
                Iterator<CompletePath> st = set.iterator();
                System.out.println("Calculating in size "+size);
                allLoops = "";
                while(st.hasNext()){
                    System.out.println("The loop");
                    allLoops += ("*" + st.next().getStringValue());
                }
                sum+=allLoops;
                if(it.hasNext())
                    set = it.next();
                else break;
            }
            sign *= Math.pow(-1, size);
            res = res.concat("+("+String. valueOf(sign*-1) +"*"+ sum+")");
            if(it.hasNext()) {
                set = it.next();
                size = set.size();
                flag = false;
            }
        }
        return res;
    }
}
