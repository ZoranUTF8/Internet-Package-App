/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author zoranjanjic
 */
public class MainClass extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        URL fxmlUrl = getClass().getClassLoader().getResource("view/View.fxml");
        GridPane root = FXMLLoader.<GridPane>load(fxmlUrl);
        
        Scene scene = new Scene(root,700, 800);
        scene.getStylesheets().add("css/style.css");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Internet Package");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
