package sample.Elements;

import sample.Data;
import sample.DrawingUtilities.Arrow;

import javafx.scene.input.MouseEvent;
import java.util.ArrayList;

public class Path {
    private Node N1;
    private Node N2;
    private boolean visited =false;
    private String value;

    public Path(){
        Arrow a;
    }

    public void setN1(Node N1){
        this.N1 = N1;
    }
    public void setN2(Node N2){
        this.N2 = N2;
    }

    public Node getN1(){
        return this.N1;
    }

    public Node getN2(){
        return this.N2;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean setBegin(MouseEvent e){
        ArrayList<Node> nodes = Data.getInstance().getNodes();
        int i;
        for(i =0;i<nodes.size();i++){
            if(nodes.get(i).Contains(e)) {
                N1 = nodes.get(i);
                System.out.println("N1 is "+N1.getLabel());
                break;
            }
        }
        if(i == nodes.size()) return false;
        return true;
    }

    public boolean setEnd(MouseEvent e){
        ArrayList<Node> nodes = Data.getInstance().getNodes();
        int i;
        for(i=0;i<nodes.size();i++){
            if(nodes.get(i).Contains(e)) {
                N2 = nodes.get(i);
//                N2.addNext(this);
                N1.addNext(this);
                System.out.println("N2 is "+N2.getLabel());
                break;
            }
        }
        if(i == nodes.size()) return false;
        return true;
    }
}
