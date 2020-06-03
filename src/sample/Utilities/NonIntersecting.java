package sample.Utilities;

import sample.Elements.CompletePath;

import java.util.*;

public class NonIntersecting {
    private static Map<CompletePath,Set<CompletePath>> nonIntersectingLPs = new HashMap<>();
    private static Map<CompletePath,Set<CompletePath>> nonIntersectingLoops = new HashMap<>();
    private static Map<CompletePath,Set<CompletePath>> mainMap = new HashMap<>();
    private static Stack<CompletePath> loops = new Stack<>();
    private static Stack<CompletePath> paths = new Stack<>();
    private static Set<Set<CompletePath>> multi = new HashSet<>();

    public NonIntersecting(){
        Traversing t = new Traversing();
        loops = t.getLoops();
        paths = t.getPaths();
        nonIntersectingLPs();
        nonIntersectingLoops();
        multipleNonTouching();
    }

    public void nonIntersectingLPs(){
        for(int i=0;i<paths.size();i++){
            for (int j =0;j<loops.size();j++){
                System.out.println("Checking for non touching "+paths.get(i).toString()+"\t"+loops.get(j).toString());
                boolean broke = nonTouching(paths.get(i).toString(),loops.get(j).toString());

                if(!broke) {
                    if (nonIntersectingLPs.containsKey(paths.get(i)))
                        nonIntersectingLPs.get(paths.get(i)).add(loops.get(j));
                    else {
                        Set<CompletePath> arrayList = new HashSet<>();
                        arrayList.add(loops.get(j));
                        nonIntersectingLPs.put(paths.get(i), arrayList);
                    }
                }
            }
            if (!nonIntersectingLPs.containsKey(paths.get(i)))
                nonIntersectingLPs.put(paths.get(i),new HashSet<>());
        }
    }

    public void nonIntersectingLoops(){
        System.out.println("Checking for Non touching ");
        for(int i=0;i<loops.size();i++){
            for (int j = 0;j<i+1;j++){
                boolean broke = nonTouching(loops.get(j).toString(),loops.get(i).toString());
                if(!broke){
                    if (mainMap.containsKey(loops.get(i))){
                        mainMap.get(loops.get(i)).add(loops.get(j));
                    }
                    else {
                        Set<CompletePath> arrayList = new HashSet<>();
                        arrayList.add(loops.get(j));
                        mainMap.put(loops.get(i), arrayList);
                    }
                }
            }
            System.out.println("Comparing "+loops.get(i).toString()+" with :");
            for (int j =i+1;j<loops.size();j++){
                System.out.println("with : "+loops.get(j).toString());
                boolean broke = nonTouching(loops.get(j).toString(),loops.get(i).toString());
                if(!broke){
                    System.out.println("Is Non Touching");
                    if (nonIntersectingLoops.containsKey(loops.get(i))){
                        nonIntersectingLoops.get(loops.get(i)).add(loops.get(j));
                        System.out.println("Adding "+loops.get(i));
                    }
                    else {
                        Set<CompletePath> arrayList = new HashSet<>();
                        arrayList.add(loops.get(j));
                        nonIntersectingLoops.put(loops.get(i), arrayList);
                    }
                }
            }
            if (!nonIntersectingLoops.containsKey(loops.get(i)))
                nonIntersectingLoops.put(loops.get(i),new HashSet<>());
        }
    }

    private boolean nonTouching(String s1,String s2){
        String[] arr = (s1.split("-"));
        boolean broke = false;
        for(int k = 0;k<arr.length;k++) {
            if (s2.contains(arr[k])) {
                broke = true;
                break;
            }
        }
        return broke;
    }

    public String printNonIntersectingLoops() {
        String nonIntersecting = "";
//        nonIntersecting = nonIntersecting.concat("Non intersecting Loops \n");
        Iterator<Set<CompletePath>> itt = multi.iterator();
        for (int i = 0; i < multi.size(); i++) {
            Iterator<CompletePath> it = (itt.next()).iterator();
            while (it.hasNext()) {
                nonIntersecting = nonIntersecting.concat(it.next().toString() + "\t");
            }
            nonIntersecting = nonIntersecting.concat("\n");
        }
        return nonIntersecting;
    }
    public String printNonIntersectingLoopsAndPaths() {
        String nonIntersecting = "";
//        nonIntersecting = nonIntersecting.concat("Non intersecting Loop with Paths\n");
        for(Map.Entry<CompletePath,Set<CompletePath>> entry : nonIntersectingLPs.entrySet()){
            nonIntersecting = nonIntersecting.concat(entry.getKey().toString()+ " :\t");
            Iterator <CompletePath> it = entry.getValue().iterator();
            while (it.hasNext())
                nonIntersecting = nonIntersecting.concat(it.next()+"\t");
            nonIntersecting = nonIntersecting.concat("\n");
        }
        System.out.print(nonIntersecting);
        return nonIntersecting;
    }

    public void multipleNonTouching(){
        initializeNonTouching();
        boolean Continue = true;
        int index = 3;
        Set<Set<CompletePath>> g = new HashSet<>();
        while(Continue){
            Continue = false;
            //Looping in the main set
            Iterator<Set<CompletePath>> itt = multi.iterator();
            while(itt.hasNext()){
                Set<CompletePath> temp = itt.next();
                if(!(temp.size()<index-1)){
                    CompletePath lastInArray = temp.iterator().next();
                    Set<CompletePath> tempSet = mainMap.get(lastInArray);
                    Iterator<CompletePath> it = tempSet.iterator();
                    while (it.hasNext()){
                        CompletePath st = it.next();
                        if(canBeAdded(temp,st)){
                            Set a = new HashSet();
                            a.addAll(temp);a.add(st);
                            g.add(a);
                            Continue = true;
                        }
                    }
                }
            }
            index++;
        }
        multi.addAll(g);
    }

    private boolean canBeAdded(Set<CompletePath> temp,CompletePath stack){
        Iterator<CompletePath> it = temp.iterator();
        while (it.hasNext()){
            if(!mainMap.get(it.next()).contains(stack)){
                return false;
            }
        }
        return true;
    }

    public void initializeNonTouching(){
        for(Map.Entry<CompletePath,Set<CompletePath>> entry : nonIntersectingLoops.entrySet()){
            if(mainMap.containsKey(entry.getKey())) mainMap.get(entry.getKey()).addAll(entry.getValue());
            else mainMap.put(entry.getKey(),entry.getValue());
            Iterator<CompletePath> it = entry.getValue().iterator();
            Set<CompletePath> temp;
            while (it.hasNext()){
                temp = new HashSet<>();
                temp.add(entry.getKey());temp.add(it.next());
                multi.add(temp);
            }
        }
    }
    public static void resetNonTouching(){
        nonIntersectingLPs = new HashMap<>();
        nonIntersectingLoops = new HashMap<>();
        loops = new Stack<>();
        paths = new Stack<>();
        multi = new HashSet<>();
        mainMap = new HashMap<>();
    }
    public static Set<Set<CompletePath>> getMainNonTouching(){
        return multi;
    }
    public static Map<CompletePath,Set<CompletePath>> getNonIntersectingLoops(){
        return nonIntersectingLoops;
    }
    public static Map<CompletePath,Set<CompletePath>> getNonIntersectingLPs(){
        return nonIntersectingLPs;
    }

}
