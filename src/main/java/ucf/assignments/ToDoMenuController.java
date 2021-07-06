/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Karina Narotam
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ToDoMenuController {
    @FXML
    public void viewListsClicked(ActionEvent actionEvent) throws IOException {
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("ToDoList.fxml"));
        Scene menuViewScene = new Scene(menuViewParent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(menuViewScene);
        window.show();
    }

    // Saves all created list to external storage
    @FXML
    public void saveAllClicked(ActionEvent actionEvent) {
        /*
            save text to file
            create new writer
            Save all to-do lists in observable list is written to a file
         */
    }

    // Upload list(s) from external storage
    @FXML
    public void uploadClicked(ActionEvent actionEvent) {
        /*
            Set up JavaFX FileChooser
            FileChooser fileChooser = new FileChooser()
            Display the FileChooser Dialog
            Read in file into to-do list format
            Switch screen to uploaded list displayed

         */
    }
}
