/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Karina Narotam
 */

package ucf.assignments;

import com.google.gson.Gson;
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
import java.util.ResourceBundle;

public class ToDoListController implements Initializable {

    @FXML private TableView<ToDo> tableView;
    @FXML private TableColumn<ToDo, String> descriptionColumn;
    @FXML private TableColumn<ToDo, String> dateColumn;
    @FXML private TableColumn<ToDo, CheckBox> statusColumn;
    @FXML private TextField descriptionTextField;
    @FXML private DatePicker dateTextField;
    @FXML MenuBar listMenu;

    private ObservableList<ToDo> list = FXCollections.observableArrayList();

    // Set up table view to perform necessary tasks
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<ToDo, String>("description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<ToDo, String>("dateString"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<ToDo, CheckBox>("select"));
        tableView.setItems(getList());
        tableView.setEditable(true);
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public ObservableList<ToDo> getList(){
        list.add(new ToDo("To-Do List - COP 3330", "2021-08-02"));
        list.add(new ToDo("Physics Quiz - PHY 2049", "2022-07-01"));
        list.add(new ToDo("CDA Quiz - PHY 2049", "2022-06-30"));
        return list;
    }

    // Allows description field to be edited
    @FXML
    public void changeDescriptionCellEvent(TableColumn.CellEditEvent cell) {
        ToDo cellSelected = tableView.getSelectionModel().getSelectedItem();
        if (cell.getNewValue().toString().length() <= 256 && cell.getNewValue().toString().length()>=1)
            cellSelected.setDescription(cell.getNewValue().toString());
    }

    // Allows date field to be edited
    @FXML
    public void changeDateCellEvent(TableColumn.CellEditEvent cell) {
        ToDo cellSelected = tableView.getSelectionModel().getSelectedItem();
        cellSelected.setDateString(cell.getNewValue().toString());
    }

    /*
        Create a new To Do object
        Fields from .getText() passed into object
        Get items from table as list
        Add new task to the list
    */
    @FXML
    public void addTaskClicked(ActionEvent actionEvent) {
        if (descriptionTextField.getText().length() >= 1 && descriptionTextField.getText().length() <= 256)
        {
            ToDo newToDo = new ToDo(descriptionTextField.getText(), dateTextField.getValue().toString());
            list.add(newToDo);
            tableView.setItems(list);
        }
    }

    // Delete specified task from list
    @FXML
    public void deleteClicked(ActionEvent actionEvent) {
        ObservableList<ToDo> selectedRows, allItems;
        allItems = tableView.getItems();
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        for (ToDo item: selectedRows) {
            list.remove(item);
        }

    }

    // Display of only completed tasks
    @FXML
    public void viewCompleteTasksClicked(ActionEvent actionEvent) {
        /*
        Create another observable list containing all the tasks with status complete
        Loop over selected rows and remove the person objects from the table that are not complete
        Display new list
        */
        ObservableList<ToDo> completeItems = FXCollections.observableArrayList();
        for (ToDo item: list) {
            if (item.getSelect().isSelected()) {
                completeItems.add(item);
            }
        }
        tableView.setItems(completeItems);
    }

    // Display of all uncompleted tasks
    @FXML
    public void viewRemainingClicked(ActionEvent actionEvent) {
         /*
            Create another observable list containing all the tasks with status incomplete
            Loop over selected rows and remove the person objects from the table that are complete
            Display new list
        */

        ObservableList<ToDo> remaining = FXCollections.observableArrayList();
        for (ToDo item: list) {
            if (!item.getSelect().isSelected()) {
                remaining.add(item);
            }
        }
        tableView.setItems(remaining);
    }

    // Display of all tasks in list
    @FXML
    public void viewAllClicked(ActionEvent actionEvent) {
        tableView.setItems(list);
    }

    // Saves list into a text file
    @FXML
    public void saveExternallyClicked(ActionEvent actionEvent) {
        /*
            save text to file
            create new writer
            Save all to-do lists in observable list is written to a file

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save List");

        Gson gson = new Gson();
        String userJson = gson.toJson(list.get(0));
        try (FileWriter file = new FileWriter("list.json")) {
            file.write(userJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    */
    }


    // Clears To-Do list display, empty list
    @FXML
    public void clearAllClicked(ActionEvent actionEvent) {
        list.clear();
        //tableView.refresh();
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

    public void viewDescriptionClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DescriptionInfo.fxml"));
        Stage stage = (Stage) listMenu.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        DescriptionInfoController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());
        stage.setScene(scene);
        stage.show();

        /*
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);



        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
         */


    }
}
