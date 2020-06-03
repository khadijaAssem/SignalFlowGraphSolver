package sample.DrawingUtilities;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;



public class Arrow extends Path {
    private static final double defaultArrowHeadSize = 5.0;

    private double endX;
    private double endY;
    private double startX;
    private double startY;


    public Arrow(){
        getElements().add(moveTo);
        getElements().add(lineTo);
        getElements().add(lineTo1);
        getElements().add(lineTo2);
        getElements().add(lineTo3);
    }
    LineTo lineTo = new LineTo();
    MoveTo moveTo = new MoveTo();
    LineTo lineTo1 = new LineTo();
    LineTo lineTo2 = new LineTo();
    LineTo lineTo3 = new LineTo();

    public void setStart(double startX,double startY){
        this.startX = startX;
        this.startY = startY;
        endX = startX;
        endY = startY;
    }

    public void setEnd(double endX,double endY){
        this.endX = endX;
        this.endY = endY;
    }

    public void draw(){
        //strokeProperty().bind(fillProperty());
        //setFill(Color.BLACK);

        //Line
        moveTo.setX(startX);moveTo.setY(startY);
        lineTo.setX(endX);lineTo.setY(endY);

        //ArrowHead
        double angle = Math.atan2((endY - startY), (endX - startX)) - Math.PI / 2.0;
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        //point1
        double x1 = (- 1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * defaultArrowHeadSize + endX;
        double y1 = (- 1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * defaultArrowHeadSize + endY;
        //point2
        double x2 = (1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * defaultArrowHeadSize + endX;
        double y2 = (1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * defaultArrowHeadSize + endY;

        lineTo1.setX(x1);
        lineTo1.setY(y1);

        lineTo2.setX(x2);
        lineTo2.setY(y2);

        lineTo3.setX(endX);
        lineTo3.setY(endY);

//        text.setX(100);
//        text.setY(100);
    }

    public double getTextXPosition(){
        return startX-((startX-endX)/2);
    }

    public double getTextYPosition(){
        return startY-((startY-endY)/2);
    }

//    public void setText(String label){
//        System.out.println(label);
////        text.setText(label);
//    }

//    public Text getText(){
//        return null;
//    }
}
