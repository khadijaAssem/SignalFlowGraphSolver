package sample;

import org.apache.commons.lang3.math.NumberUtils;
import sample.Elements.Node;

import java.util.ArrayList;

public class Data
{
    private static Data ourInstance = new Data();
    private static boolean alphabetic = false;

    public static Data getInstance() {
        return ourInstance;
    }

    private static ArrayList<Node> nodes = new ArrayList<>();

    private Data() {
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public ArrayList<Node> getNodes(){
        return nodes;
    }

    public static void isAlphabetic(String s){
        if (alphabetic == false && !NumberUtils.isNumber(s)){
            alphabetic = true;
        }
    }
    public static boolean getIsAlphabetic(){
        return alphabetic;
    }
    public static void resetData(){
        alphabetic = false;
        nodes = new ArrayList<>();
    }

}
