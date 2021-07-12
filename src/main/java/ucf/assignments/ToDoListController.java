/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Karina Narotam
 */

package ucf.assignments;

import com.google.gson.*;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ToDoListController implements Initializable {

    @FXML private TableView<ToDo> tableView;
    @FXML private TableColumn<ToDo, String> descriptionColumn;
    @FXML private TableColumn<ToDo, String> dateColumn;
    @FXML private TableColumn<ToDo, CheckBox> statusColumn;
    @FXML private TextField descriptionTextField;
    @FXML private DatePicker dateTextField;
    @FXML MenuBar listMenu;
    @FXML private MenuItem saveExternally;

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
        tableView.setItems(addTask(descriptionTextField.getText(), dateTextField.getValue().toString()));
    }

    public ObservableList addTask(String description, String date) {
        if (description.length() >= 1 && description.length() <= 256)
        {
            ToDo newToDo = new ToDo(description, date);
            list.add(newToDo);
        }
        return list;
    }

    // Delete specified task from list
    @FXML
    public void deleteClicked(ActionEvent actionEvent) {
        deleteTask();
    }

    public void deleteTask() {
        ObservableList<ToDo> selectedRows;
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        for (ToDo item: selectedRows) {
            list.remove(item);
        }
    }

    // Display of only completed tasks
    @FXML
    public void viewCompleteTasksClicked(ActionEvent actionEvent) {
        tableView.setItems(viewComplete());
    }

    public ObservableList viewComplete() {
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
        return completeItems;
    }


    // Display of all uncompleted tasks
    @FXML
    public void viewRemainingClicked(ActionEvent actionEvent) {
        tableView.setItems(viewRemaining());
    }

    public ObservableList viewRemaining() {
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
        return remaining;

    }

    // Display of all tasks in list
    @FXML
    public void viewAllClicked(ActionEvent actionEvent) {
        tableView.setItems(list);
    }


    // Clears To-Do list display, empty list
    @FXML
    public void clearAllClicked(ActionEvent actionEvent) {
        list.clear();
    }

    // Upload list from external storage
    @FXML
    public void loadListClicked(ActionEvent actionEvent) {
        Stage stage = (Stage)listMenu.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load List");
        File theFile = fileChooser.showOpenDialog(stage);
        parse(theFile);
    }
    /*
        save text to file
        create new writer
        Save all to-do lists in observable list is written to a file
    */
    @SuppressWarnings("unchecked")
    @FXML
    public void saveExternallyClicked(ActionEvent actionEvent) throws FileNotFoundException {
        Stage stage = (Stage)listMenu.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save List");
        //File theFile = fileChooser.showOpenDialog(stage);

        File theFile = fileChooser.showSaveDialog(stage);
        ArrayList <ArrayToDo> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
           arrayList.add(new ArrayToDo(list.get(i).getDescription(), list.get(i).getDateString()));
        }
        Gson gson = new Gson();
        String arrayJson = gson.toJson(arrayList);
        saveTexttoFile(arrayJson, theFile);
    }

    public void saveTexttoFile(String content, File file) throws FileNotFoundException {
        PrintWriter writer;
        writer = new PrintWriter(file);
        writer.println("{\"toDoList\" : " + content + "}");
        writer.close();
    }

    public void parse(File file) {
        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(file));
            JsonObject fileObject = fileElement.getAsJsonObject();

            // process products
            JsonArray jsonArrayProducts = fileObject.get("toDoList").getAsJsonArray();

            for (JsonElement productElement : jsonArrayProducts) {
                JsonObject productJsonObject = productElement.getAsJsonObject();
                // extract data
                String date = productJsonObject.get("dateString").getAsString();
                String description = productJsonObject.get("description").getAsString();

                ToDo newItem = new ToDo(description, date);
                System.out.println(newItem.getDateString());
                System.out.println(newItem.getDescription());
                list.add(newItem);
                tableView.setItems(list);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error input file not found!");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error processing input file");
            e.printStackTrace();
        }
    }

}
