package sample.Elements;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import javafx.scene.input.MouseEvent;
import java.util.ArrayList;

public class Node {
    private Circle node;
    private Text text;
    private String label;
    private boolean visited = false;
    private ArrayList<Path> next;
    private int counter = 0;

    public Node(){
        node = new Circle();
        text = new Text();

        node.setRadius(20);
        node.setFill(Color.WHITE);
        node.setStroke(Color.BLACK);

        next = new ArrayList<>();
    }

    public void setCenter(double x,double y){
        node.setCenterX(x);
        node.setCenterY(y);

        text.setX(x-5);
        text.setY(y+5);
    }
    public Circle getNode(){
        return node;
    }
    public Text getText(){
        return text;
    }



    public void setLabel(String label){
        this.label = label;
        text.setText(label);
    }
    public String getLabel(){
        return this.label;
    }

    public void addNext(Path next){
        this.next.add(next);
    }

    public Path getNext(){
        return next.get(counter++);
    }
    public boolean hasNext(){
        return counter < next.size();
    }
    public int getCounter(){
        return counter;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void resetCounter(){
        counter = 0;
    }

    public boolean Contains(MouseEvent e){
        Circle c = new Circle();
        c.setCenterX(node.getCenterX());
        c.setCenterY(node.getCenterY());
        c.setRadius(25);
        Point2D p = new Point2D(e.getX(),e.getY());
        return c.contains(p);
    }

    public void printNodeData(){
        System.out.println("From print node data");
        System.out.println("Node LAbel is " + label);
        System.out.println("The node has the following paths");
        for (int i = 0;i<next.size();i++){
            System.out.println(next.get(i).getValue()+" going to "+next.get(i).getN2().getLabel());
        }
        System.out.println("Done printing node data");
    }
}
