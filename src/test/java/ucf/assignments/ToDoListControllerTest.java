/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Karina Narotam
 */
package ucf.assignments;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListControllerTest {
    private ObservableList list, newList;
    @Test
    void addTaskClicked() {

        ToDoListController controller= new ToDoListController();
        list = controller.addTask("Assignment4", "COP3330");
        newList = controller.addTask("Quiz3", "PHY2049");
        assertNotEquals(list, newList);


        // make a new ToListController
        // add sample values for ToDoListofLists object
        // another list of tasks with additional task
        // assert lists are equal after command
    }

    @Test
    void deleteTaskClicked() {
        // make a new ToListController
        // add sample values for ToDoListofLists object
        // another list of tasks without chosen task
        // assert lists are equal after command
    }

    @Test
    void viewCompleteTasksClicked() {

        // make a new ToDoListController
        // add sample values for ToDoListofLists object
        // create ToDoListofLists object with to-do lists status complete
        // assert if view remaining displays same items
    }

    @Test
    void viewRemainingClicked() {
        // make a new ToDoListController
        // add sample values for ToDoListofLists object
        // create ToDoListofLists object with to-do lists status incomplete
        // assert if view remaining displays same items
    }

    @Test
    void saveExternallyClicked() {
        // save currently viewed list
        // test if file exists
    }
}