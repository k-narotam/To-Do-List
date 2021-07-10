/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Karina Narotam
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import java.io.IOException;


public class InstructionsController {

    @FXML MenuBar helpBar;

    public void backClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) helpBar.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("ToDoList.fxml")));
        stage.setScene(scene);
        stage.show();
    }
}
