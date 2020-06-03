package sample.Utilities;

import sample.Data;
import sample.Elements.Node;

public class MasonsFormula {

    private static String pathsAndLoops;
    private static String nonInterLoo;
    private static String NonInterLooPath;
    private static String resul;


    public static String Calculate(Node initial){
        Data data = Data.getInstance();
        if (data.getIsAlphabetic())
            return CalculateString(initial);
        return CalculateDouble(initial);
    }

    private static String CalculateDouble(Node initial){
//        String result = "";
        System.out.println("Is Double");
        pathsAndLoops = Traversing.Traverse(initial);
        NonIntersecting non = new NonIntersecting();
        CalculateNumerator c = new CalculateNumerator();
        CalculateDenominator c1 = new CalculateDenominator();
        nonInterLoo = non.printNonIntersectingLoops();
        NonInterLooPath = non.printNonIntersectingLoopsAndPaths();
        double num = c.Calculate();
        double den = c1.Calculate();
        System.out.println(num);
        System.out.println(den);
        double rResult = num/den;
        resul = "result = "+String.valueOf(rResult);
        return resul;
    }
    private static String CalculateString(Node initial){
//        String result = "";
        System.out.println("Is String");
        pathsAndLoops = Traversing.Traverse(initial);
        NonIntersecting non = new NonIntersecting();
        CalculateNumerator c = new CalculateNumerator();
        CalculateDenominator c1 = new CalculateDenominator();
        nonInterLoo = non.printNonIntersectingLoops();
        NonInterLooPath = non.printNonIntersectingLoopsAndPaths();
        String num = c.CalculateSting();
        String den = c1.CalculateSting();
        System.out.println(num);
        System.out.println(den);
        String rResult = num+"/"+den;
        resul = "result = " + (rResult);
        return resul;
    }

    public static String getPathsAndLoops() {
        return pathsAndLoops;
    }

    public static String getNonInterLoo() {
        return nonInterLoo;
    }

    public static String getNonInterLooPath() {
        return NonInterLooPath;
    }

    public static String getResul() {
        return resul;
    }
}
