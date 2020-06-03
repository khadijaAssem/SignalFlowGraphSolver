package sample.Utilities;

import sample.Elements.CompletePath;
import sample.Elements.Path;

import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class CalculateValuesStrings {
    public String paths(Stack<Path> p){
//        System.out.print("Path = " );
        String M = "";
        for (int i=0;i<p.size();i++){
            M = M.concat(p.get(i).getValue());
        }
//        System.out.println(M);
        return M;
    }
    public String delta(Set<CompletePath> v){
        System.out.print("Delta = ");
        String delta = "";
        Iterator<CompletePath> it = v.iterator();
        while (it.hasNext()){
            delta += it.next().getStringValue();
        }
        delta = "1"+"-"+delta;
        System.out.println(delta);
        return delta;
    }
}
