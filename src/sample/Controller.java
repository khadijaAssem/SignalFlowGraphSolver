package sample;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.DetailsWindow.StartUpTest;
import sample.Elements.*;
import sample.DrawingUtilities.Arrow;
import sample.Utilities.MasonsFormula;
import sample.Utilities.NonIntersecting;
import sample.Utilities.Traversing;

import java.util.ArrayList;

public class Controller {
    private boolean addingNode = false;
    private boolean addingPath = false;
    private Data data = Data.getInstance();
    private ArrayList<Node> nodes = data.getNodes();
    private Path path;
    private Arrow a;
    private Text pathText;
    private int i =0;

    @FXML
    private Pane pane;
    @FXML
    private TextField nodeLabel;
    @FXML
    private TextField pathValue;
    @FXML
    private Label result;
    @FXML
    private ToggleButton deleteNodeButton;
    @FXML
    private ImageView deleteIcon;


    @FXML
    void newNode(){
        System.out.println("Enter the node label");
        nodeLabel.setVisible(true);
    }
    @FXML
    void createNode(KeyEvent keyPressed){
        if(keyPressed.getCode()== KeyCode.ENTER) {
            addingNode = true;
            Node node = new Node();
            data.addNode(node);
            nodes.get(nodes.size() - 1).setCenter(384, 114);
            node.setLabel(nodeLabel.getText());
            pane.getChildren().addAll(node.getNode(),node.getText());
            nodeLabel.setVisible(false);
            nodeLabel.setText("");
        }
    }
    @FXML
    void newPath(){
        System.out.println("New Path");
        pathValue.setVisible(true);
    }
    @FXML
    void createPath(KeyEvent keyPressed){
        if(keyPressed.getCode()== KeyCode.ENTER) {
            a = new Arrow();
            pathText = new Text();
            path = new Path();
            addingPath = true;
            path.setValue(pathValue.getText());
            data.isAlphabetic(pathValue.getText());
            pathText.setText(pathValue.getText());
            pathValue.setText("");
        }
    }
    @FXML
    void Hovering(MouseEvent mouseHover){
        deleteIcon.setX(mouseHover.getX()-610);
        deleteIcon.setY(mouseHover.getY()-200);
        if (addingNode){
            nodes.get(nodes.size()-1).setCenter(mouseHover.getX(),mouseHover.getY());
        }
        else if (addingPath&&i==1){
            a.setEnd(mouseHover.getX(),mouseHover.getY());
            pathText.setX(a.getTextXPosition());
            pathText.setY(a.getTextYPosition());
            a.draw();
        }
    }

    @FXML
    public void mouseClicked(MouseEvent mouseClicked){
        if (deleteNodeButton.isSelected()){
            for(int j =0;j<nodes.size();j++){
                if(nodes.get(j).Contains(mouseClicked)) {
                    pane.getChildren().remove(nodes.get(j).getNode());
                    pane.getChildren().remove(nodes.get(j).getText());
                    data.getNodes().remove(nodes.get(j));
                    break;
                }
            }
            deleteNodeButton.setSelected(false);
            deleteIcon.setVisible(false);
        }
    }
    @FXML
    void fixElement(MouseEvent mousePosition){
        if (addingNode){
            nodes.get(nodes.size()-1).setCenter(mousePosition.getX(),mousePosition.getY());
            addingNode = false;
            nodeLabel.setVisible(false);
        }
        else if (addingPath){
            if (i == 0){
                if(path.setBegin(mousePosition)) {
                    i=1;
                    a = new Arrow();
                    a.setStart(mousePosition.getX(),mousePosition.getY());
                    a.draw();
                    pane.getChildren().add(a);

                    pathText.setX(a.getTextXPosition());
                    pathText.setY(a.getTextYPosition());
                    pane.getChildren().add(pathText);
                }
            }
            else if(i == 1){
                if(path.setEnd(mousePosition)){
                    i=0;
                    a.setEnd(mousePosition.getX(),mousePosition.getY());
                    a.draw();
                    addingPath = false;
                    pathValue.setVisible(false);
                    pathText.setX(a.getTextXPosition());
                    pathText.setY(a.getTextYPosition());
                }
            }
        }
    }

    @FXML
    public void Solve(){
        Reset();
        for (int i=0;i<nodes.size();i++){
            System.out.println("index "+i);
            nodes.get(i).printNodeData();
        }
        result.setText(MasonsFormula.Calculate(nodes.get(0)));
    }
    @FXML
    public void showDetails() throws Exception {
        StartUpTest startUpTest = StartUpTest.waitForStartUpTest();
        startUpTest.printSomething();
        Stage s = new Stage();
        startUpTest.start(s);
    }
    @FXML
    public void deleteNode(){
        deleteIcon.setVisible(deleteNodeButton.isSelected());
    }
    @FXML
    public void Clear(){
        Reset();
        Data.resetData();
        nodes = new ArrayList<>();
        pane.getChildren().clear();
    }
    private void Reset(){
        Traversing.resetTraversing();
        NonIntersecting.resetNonTouching();
    }
}