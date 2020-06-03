package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Elements.Node;
import sample.Elements.Path;
import sample.Utilities.*;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Signal Flow Graph Solver");
        primaryStage.setScene(new Scene(root, 1000, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

//public class Main {
//    public static void main(String[] args){
//        Node y1 = new Node();y1.setLabel("Y1");
//        Node y2 = new Node();y2.setLabel("Y2");
//
//        Path p1 = new Path();
//        p1.setN1(y1);p1.setN2(y2);
//        p1.setValue("1");
//
//        y1.addNext(p1);
//
//        Node y3 = new Node();y3.setLabel("Y3");
//
//        Path p2 = new Path();
//        p2.setN1(y2);p2.setN2(y3);
//        p2.setValue("5");
//
//        y2.addNext(p2);
//
//
//        Node y4 = new Node();y4.setLabel("Y4");
//
//        Path p3 = new Path();
//        p3.setN1(y3);p3.setN2(y4);
//        p3.setValue("10");
//
//        y3.addNext(p3);
//
//        Node y5 = new Node();y5.setLabel("Y5");
//
//        Path p4 = new Path();
//        p4.setN1(y4);p4.setN2(y5);
//        p4.setValue("2");
//
//        y4.addNext(p4);
//
//        Path p5 = new Path();
//        p5.setN1(y5);p5.setN2(y2);
//        p5.setValue("-1");
//
//        y5.addNext(p5);
//
//        Path p6 = new Path();
//        p6.setN1(y5);p6.setN2(y4);
//        p6.setValue("-2");
//
//        y5.addNext(p6);
//
//        Path p7 = new Path();
//        p7.setN1(y4);p7.setN2(y3);
//        p7.setValue("-1");
//
//        y4.addNext(p7);
//
//        Node y6 = new Node();y6.setLabel("Y6");
//
//        Path p8 = new Path();
//        p8.setN1(y2);p8.setN2(y6);
//        p8.setValue("10");
//
//        y2.addNext(p8);
//
//        Path p9 = new Path();
//        p9.setN1(y6);p9.setN2(y6);
//        p9.setValue("-1");
//
//        y6.addNext(p9);
//
//        Path p10 = new Path();
//        p10.setN1(y6);p10.setN2(y5);
//        p10.setValue("2");
//
//        y6.addNext(p10);
//
//        Node y7 = new Node();y7.setLabel("Y7");
//
//        Path p11 = new Path();
//        p11.setN1(y5);p11.setN2(y7);
//        p11.setValue("1");
//
//        y5.addNext(p11);
//
//        Traversing.resetTraversing();
//        NonIntersecting.resetNonTouching();
//
//        MasonsFormula.Calculate(y1);
//
//
////        Node y1 = new Node();y1.setLabel("Y1");
////        Node y2 = new Node();y2.setLabel("Y2");
////        Node y3 = new Node();y3.setLabel("Y3");
////        Node y4 = new Node();y4.setLabel("Y4");
////        Node y5 = new Node();y5.setLabel("Y5");
////        Node y6 = new Node();y6.setLabel("Y6");
////        Node y7 = new Node();y7.setLabel("Y7");
////
////        Path p1 = new Path();
////        p1.setN1(y1);p1.setN2(y2);
////        p1.setValue("1");
////
////        y1.addNext(p1);
////
////        Path p2 = new Path();
////        p2.setN1(y2);p2.setN2(y3);
////        p2.setValue("5");
////
////        y2.addNext(p2);
////
////
////        Path p3 = new Path();
////        p3.setN1(y3);p3.setN2(y4);
////        p3.setValue("10");
////
////        y3.addNext(p3);
////
////        Path p4 = new Path();
////        p4.setN1(y4);p4.setN2(y5);
////        p4.setValue("2");
////
////        y4.addNext(p4);
////
////        Path p5 = new Path();
////        p5.setN1(y5);p5.setN2(y6);
////        p5.setValue("2");
////
////        y5.addNext(p5);
////
////        Path p6 = new Path();
////        p6.setN1(y5);p6.setN2(y7);
////        p6.setValue("1");
////
////        y5.addNext(p6);
////
////        Path p7 = new Path();
////        p7.setN1(y6);p7.setN2(y5);
////        p7.setValue("8");
////
////        y6.addNext(p7);
////
////        Path p8 = new Path();
////        p8.setN1(y4);p8.setN2(y3);
////        p8.setValue("6");
////
////        y4.addNext(p8);
////
////        Path p9 = new Path();
////        p9.setN1(y2);p9.setN2(y1);
////        p9.setValue("3");
////
////        y2.addNext(p9);
//
////        Traversing.Traverse(y1);
////        NonIntersecting non = new NonIntersecting();
////        CalculateNumerator c = new CalculateNumerator();
////        CalculateDenominator c1 = new CalculateDenominator();
////        non.printNonIntersecting();
////        System.out.println(c.Calculate());
////        System.out.println(c1.Calculate());
//
//    }
//}
