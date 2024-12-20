package com.example.pratica824;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("first-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 550);
        stage.setTitle("Paolino il Mago dello Spiedino");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(HelloApplication.class.getResource("/com/example/pratica824/img/icon.png").toString()));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}