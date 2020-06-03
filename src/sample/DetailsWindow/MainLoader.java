package sample.DetailsWindow;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.concurrent.CountDownLatch;

public class MainLoader extends Application {
    public static final CountDownLatch latch = new CountDownLatch(1);
    public static MainLoader startUpTest = null;

    public static MainLoader waitForStartUpTest() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return startUpTest;
    }

    public static void MainLoader(MainLoader startUpTest0) {
        startUpTest = startUpTest0;
        latch.countDown();
    }

    public MainLoader() {
        MainLoader(this);
    }

    public void printSomething() {
        System.out.println("You called a method on the application");
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Platform.setImplicitExit(false);
        Parent root = FXMLLoader.load(getClass().getResource("FXML2.fxml"));
        primaryStage.setTitle("Game Over");
        primaryStage.setScene(new Scene(root, 379, 435));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}