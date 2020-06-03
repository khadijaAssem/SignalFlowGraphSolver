package sample.Utilities;

import javafx.util.Pair;
import sample.Elements.CompletePath;
import sample.Elements.Node;
import sample.Elements.Path;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Traversing {
    private static Stack<Path> stack = new Stack<>();
    private static Stack<CompletePath> loops = new Stack<>();
    private static Stack<CompletePath> paths = new Stack<>();
    private static Set<String> setOfPaths = new HashSet<>();

    private String storeNodes;


    public static String Traverse(Node n){
        String traversingResult = "";
        Traversing t = new Traversing();
        t.Forward(n);
//        System.out.println("Paths");
        traversingResult = traversingResult.concat(t.printPaths());
//        System.out.println("Loops");
        traversingResult = traversingResult.concat(t.printLoops());
        return traversingResult;
    }

    public void Forward(Node initial){
        System.out.println("Forward Began");
        boolean broke = false;
        System.out.println("Initial "+initial.getLabel());
        Path path = initial.getNext();
        initial.setVisited(true);
        System.out.println("First Path "+path.getValue());
        stack.push(path);
        Node temp = path.getN2();
        System.out.println(temp.getLabel());
        while(temp.hasNext()) {
            if(temp.isVisited()) {
                setLoop();
                broke = true;
                break;
            }
            Path n = temp.getNext();
            stack.push(n);
            n.setVisited(true);//Path
            temp.setVisited(true);//node
            System.out.println(n.getValue());
            System.out.println(temp.getLabel());
            temp = n.getN2();
        }
        if(temp.isVisited()) {
            setLoop();
            broke = true;
        }
        if(!broke) {
            Stack tempStack = (Stack<Pair<Path, Integer>>) stack.clone();
            checkStack(stack);
            if(!setOfPaths.contains(storeNodes)){
                CompletePath p = new CompletePath(tempStack,storeNodes);
                paths.push(p);
                setOfPaths.add(storeNodes);
            }
        }
        System.out.println("Forward done");
        Backward();
        System.out.println("Forward and backward done");
    }

    public void Backward(){
        System.out.println("Backward Began");
        while(!stack.empty()){
            Path p = stack.pop();
            Node n = p.getN1();
            System.out.println("Node is "+n.getLabel());
            if(!n.hasNext()){
                System.out.println("Resetting Node "+n.getLabel());
                n.setVisited(false);
                p.setVisited(false);
                n.resetCounter();
            }
            else {
                this. Forward(p.getN1());
            }
        }
        System.out.println("Backward done");
    }

    private void setLoop(){
        Node start = stack.peek().getN2();
        int size = stack.size();
        Stack<Path> tempStack = (Stack<Path>) stack.clone();
        for(int i=0;i<size;i++){
            if(stack.get(i).getN1()!=start){
                tempStack.remove(stack.get(i));
            }
            else break;
        }
        checkStack(tempStack);
        if(!setOfPaths.contains(storeNodes)){
            String temp = "";
            if(tempStack.size()==2){
                temp = tempStack.get(1).getN1().getLabel()+"-"+tempStack.get(0).getN1().getLabel()+"-"+tempStack.get(1).getN1().getLabel()+"-";
            }
            if (!setOfPaths.contains(temp)) {
                CompletePath c = new CompletePath(tempStack,storeNodes);
                loops.push(c);
                setOfPaths.add(storeNodes);
            }
        }
    }

    private void checkStack(Stack<Path> stack) {
        storeNodes = stack.get(0).getN1().getLabel()+"-";
        for(int i=0;i<stack.size();i++){
            storeNodes += (stack.get(i).getN2().getLabel()+"-");
        }
    }

    public String printLoops(){
        String loopsString = "Loops\n";
        for(int i=0;i<loops.size();i++){
            loopsString = loopsString.concat(loops.get(i).toString()+" = "+loops.get(i).getStringValue()+"\n");
        }
        System.out.print(loopsString);
        return loopsString;
    }
    public String printPaths(){
        String pathsString = "Paths\n";
        for(int i=0;i<paths.size();i++){
            pathsString = pathsString.concat(paths.get(i).toString()+" = "+paths.get(i).getStringValue()+"\n");
        }
        System.out.print(pathsString);
        return pathsString;
    }

    public Stack<CompletePath> getLoops(){
        return loops;
    }

    public Stack<CompletePath> getPaths(){
        return paths;
    }

    public static void resetTraversing(){
        stack = new Stack<>();
        loops = new Stack<>();
        paths = new Stack<>();
        setOfPaths = new HashSet<>();
    }

}
