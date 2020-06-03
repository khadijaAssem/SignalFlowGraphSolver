package sample.Utilities;

import javafx.util.Pair;
import sample.Elements.CompletePath;
import sample.Elements.Path;

import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class CalculateValuesNumbers {
    public Double paths(Stack<Path> p){
//        System.out.print("Path = " );
        double M = 1;
        for (int i=0;i<p.size();i++){
            M*= Double.valueOf(p.get(i).getValue());
        }
//        System.out.println(M);
        return M;
    }
    public Double delta(Set<CompletePath> v){
        System.out.print("Delta = ");
        double delta = 0;
        Iterator <CompletePath> it = v.iterator();
        while (it.hasNext()){
            delta += it.next().getValue();
        }
        delta = 1-delta;
        System.out.println(delta);
        return delta;
    }
}
