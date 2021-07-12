package ucf.assignments;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/*
    NOTE: Class used solely for testing purposes
 */

public class ToDoListMethods {
    public ArrayList<ArrayToDo> addTask(String description, String date, ArrayList<ArrayToDo> list) {
        if (description.length() >= 1 && description.length() <= 256) {
            ArrayToDo newToDo = new ArrayToDo(description, date);
            list.add(newToDo);
        }
        return list;
    }

    public ObservableList viewComplete(ObservableList<ToDo> list) {
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

    public ObservableList viewRemaining(ObservableList<ToDo> list) {
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

    public ArrayList<ArrayToDo> parse(File file) {
        ArrayList<ArrayToDo> list= new ArrayList<>();
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

                ArrayToDo newItem = new ArrayToDo(description, date);
                list.add(newItem);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error input file not found!");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error processing input file");
            e.printStackTrace();
        }
        return list;
    }
}
