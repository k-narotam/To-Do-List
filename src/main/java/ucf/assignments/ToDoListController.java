/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Karina Narotam
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class ToDoListController implements Initializable {

    @FXML private TableView<ToDo> tableView;
    @FXML private TableColumn<ToDo, String> itemColumn;
    @FXML private TableColumn<ToDo, String> descriptionColumn;
    @FXML private TableColumn<ToDo, LocalDate> dateColumn;
    @FXML private TableColumn<ToDo, Boolean> statusColumn;
    @FXML private TextField item;
    @FXML private TextField description;
    @FXML private DatePicker date;
    private TableView<ToDo> table = new TableView<ToDo>();
    private final ObservableList<ToDo> data =
            FXCollections.observableArrayList(
                    new ToDo("To-Do List project", "COP 3330", LocalDate.of(2021, Month.JULY, 11))
            );

    @FXML MenuBar listMenu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemColumn.setCellValueFactory(new PropertyValueFactory<ToDo, String>("item"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<ToDo, String>("description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<ToDo, LocalDate>("date"));
        tableView.setItems(data);
        tableView.setEditable(true);
        itemColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }


    @FXML
    public void homeClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) listMenu.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("ToDoMenu.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    /* New method
        Configure TableView
         @FXML private TableView<To Do> tableView;
         Configure each column (complete, date, item, description)
         private TableColumn<To-Do, String> task;
         Update fx:id on scene builder

         Create instance variables used to create new To-do objects

         Create new ToDoList object
     */
    public void changeItem(TableColumn.CellEditEvent cell) {
         /*
        Create "CellEditEvent"s to allow each list item to be edited
        tableView.getSelectionModel().getSelectedItem()
        Update "onEditCommit" on scene builder

        configure table to be able to select multiple rows
     */
    }


    @FXML
    public void addTaskClicked(ActionEvent actionEvent) {
        /*
            Create a new To Do object
            Fields from .getText() passed into object

            Get items from table as list
            Add new task to the list

            Configure fx:id on scene builder

         */
    }

    // Delete specified task from list
    @FXML
    public void deleteTaskClicked(ActionEvent actionEvent) {
        /*
        Create another observable list containing all the selected tasks for deletion
        Loop over selected rows and remove the person objects from the table
     */

    }

    // Display of only completed tasks
    @FXML
    public void viewCompleteTasksClicked(ActionEvent actionEvent) {
        /*
        Create another observable list containing all the tasks with status complete
        Loop over selected rows and remove the person objects from the table that are not complete
        Display new list
        */

    }

    // Display of all uncompleted tasks
    @FXML
    public void viewRemainingClicked(ActionEvent actionEvent) {
         /*
            Create another observable list containing all the tasks with status incomplete
            Loop over selected rows and remove the person objects from the table that are complete
            Display new list
        */
    }

    // Saves list into a text file
    @FXML
    public void saveExternallyClicked(ActionEvent actionEvent) {
        /*
            save text to file
            create new writer
            Save all to-do lists in observable list is written to a file
         */
    }


    // Clears To-Do list display, empty list
    @FXML
    public void clearAllClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void aboutClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) listMenu.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("InstructionsPage.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    // Upload list from external storage
    @FXML
    public void loadListClicked(ActionEvent actionEvent) {
        /*
            Set up JavaFX FileChooser
            FileChooser fileChooser = new FileChooser()
            Display the FileChooser Dialog
            Read in file into to-do list format
            Switch screen to uploaded list displayed

         */
    }
}
