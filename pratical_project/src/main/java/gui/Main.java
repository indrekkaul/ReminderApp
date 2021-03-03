package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gui/login.fxml"));
        primaryStage.setTitle("Currency System");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
 /*   public void start(Stage primaryStage) throws Exception{
        //System.out.println(getClass().getResource("gui/login.fxml").getPath());

*//*        FXMLLoader loader = new FXMLLoader(getClass().getResource("gui/login.fxml"));
        Parent root = loader.load();*//*

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/login.fxml"));
        primaryStage.setTitle("Currency System");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }*/


    public static void main(String[] args) {
        launch(args);
    }
}
