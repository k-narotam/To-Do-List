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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

public class ToDoListController {

    @FXML private TableView<ToDo> tableView;
    @FXML private TableColumn<ToDo, String> itemColumn;
    @FXML private TableColumn<ToDo, String> descriptionColumn;
    @FXML private TableColumn<ToDo, LocalDate> dateColumn;
    @FXML private TableColumn<ToDo, String> statusColumn;
    // Load scene for returning to main menu
    @FXML
    public void homeClicked(ActionEvent actionEvent) throws IOException {
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("ToDoMenu.fxml"));
        Scene menuViewScene = new Scene(menuViewParent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(menuViewScene);
        window.show();
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

    // Deletes current list
    @FXML
    public void deleteListClicked(ActionEvent actionEvent) {
        /*
            search for selected list in ToDoListofLists
            delete displayed list from ToDoListofLists object
         */
    }


    public void createNewList(ActionEvent actionEvent) {
    /*
        Creates new To-Do list, increment to ToDoListofList
        Change table view to reflect new list
        Show new view of To-Do list
        Configure combo box to handle multiple list displays
     */
    }

    public void sortTable(ActionEvent actionEvent) {
        /*
            Sorting algorithm that sorts To-Do observable list
            by date, changing display of table
         */
    }
}
