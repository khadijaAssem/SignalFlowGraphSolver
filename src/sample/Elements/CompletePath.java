package sample.Elements;

import sample.Data;
import sample.Utilities.CalculateValuesNumbers;
import sample.Utilities.CalculateValuesStrings;

import java.util.Stack;

public class CompletePath {
    private Stack<Path> path;
    private double value;
    private String stringValue;
    private String toString;

    public CompletePath(Stack<Path> path,String toString){
        this.path = path;
        this.toString = toString;
        setValue();
    }

    public Stack<Path> getPath() {
        return path;
    }

    public void setPath(Stack<Path> path) {
        this.path = path;
    }

    public double getValue() {
        return value;
    }
    public String getStringValue() {
        if(!Data.getInstance().getIsAlphabetic())
            return String.valueOf(value);
        return stringValue;
    }

    public void setValue() {
        if(!Data.getInstance().getIsAlphabetic()) {
            CalculateValuesNumbers c = new CalculateValuesNumbers();
            this.value = c.paths(path);
        }
        else {
            CalculateValuesStrings c = new CalculateValuesStrings();
            this.stringValue = c.paths(path);
            System.out.println("**********From Complete Path"+stringValue);
        }
    }

    public String toString() {
        return toString;
    }
}
