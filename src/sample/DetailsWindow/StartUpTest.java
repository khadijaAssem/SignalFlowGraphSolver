package sample.DetailsWindow;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.concurrent.CountDownLatch;

public class StartUpTest extends Application {
    public static final CountDownLatch latch = new CountDownLatch(1);
    public static StartUpTest startUpTest = null;

    public static StartUpTest waitForStartUpTest() {
        if(startUpTest == null) startUpTest = new StartUpTest();
        return startUpTest;
    }

    public static void setStartUpTest(StartUpTest startUpTest0) {
//        startUpTest = startUpTest0;
//        latch.countDown();
    }

    public StartUpTest() {
        setStartUpTest(this);
    }

    public void printSomething() {
        System.out.println("You called a method on the application");
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Platform.setImplicitExit(false);
        Parent root = FXMLLoader.load(getClass().getResource("detailsWindow.fxml"));
        primaryStage.setTitle("Output");
        primaryStage.setScene(new Scene(root, 402, 570));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}