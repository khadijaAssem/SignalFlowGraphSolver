package sample.DetailsWindow;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import sample.Utilities.MasonsFormula;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailsWindow implements Initializable {
    @FXML
    private TextArea pathsAndLoops;
    @FXML
    private TextArea nonInterLoo;
    @FXML
    private TextArea NonInterLooPath;
    @FXML
    private TextArea resul;

    private void initiate(){
        pathsAndLoops.setText(MasonsFormula.getPathsAndLoops());
        nonInterLoo.setText(MasonsFormula.getNonInterLoo());
        NonInterLooPath.setText(MasonsFormula.getNonInterLooPath());
        resul.setText(MasonsFormula.getResul());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initiate();
    }
}
