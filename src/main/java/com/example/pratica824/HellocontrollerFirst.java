package com.example.pratica824;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HellocontrollerFirst {
    @FXML
    private Button b10;

    @FXML
    public void initialize() {
        b10.setOnMouseMoved(event -> {
            b10.setStyle("-fx-background-color: #95758A; -fx-background-radius: 36;");
        });
    }
    @FXML
    private void switchToHelloView(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 550);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.setScene(scene);
    }
}
