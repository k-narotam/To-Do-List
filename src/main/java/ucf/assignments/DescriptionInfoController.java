package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

import java.io.IOException;

public class DescriptionInfoController {
    @FXML MenuBar descriptionBar;
    @FXML private Label descriptionLabel;

    public void initData(ToDo description) {
        descriptionLabel.setText(description.getDescription());
    }
    public void backClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) descriptionBar.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("ToDoList.fxml")));
        stage.setScene(scene);
        stage.show();
    }
}
