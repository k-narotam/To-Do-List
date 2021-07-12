/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Karina Narotam
 */
package ucf.assignments;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListControllerTest {
    private ArrayList<ArrayToDo> list = new ArrayList<>();
    private ArrayList<ArrayToDo> expected = new ArrayList<>();
    @Test
    void addTaskClicked() {

        ToDoListMethods methods= new ToDoListMethods();
        list = methods.addTask("Assignment4", "2021-07-11", list);
        expected.add(new ArrayToDo("Assignment4", "2021-07-11"));
        assertEquals(list.get(0).getDescription(), expected.get(0).getDescription());
    }

    @Test
    void deleteTaskClicked() {
        ToDoListMethods methods= new ToDoListMethods();
        list = methods.addTask("Assignment4", "2021-07-11", list);
        expected.add(new ArrayToDo("Assignment4", "2021-07-11"));
        list.remove(0);
        expected.remove(0);
        assertEquals(list.size(), expected.size());
    }

    @Test
    void clearTest() {
        ToDoListMethods methods= new ToDoListMethods();
        list = methods.addTask("Assignment4", "2021-07-11", list);
        list.clear();
        assert(list.size()==0);
    }

    @Test
    void fileTest() {
        ToDoListMethods methods= new ToDoListMethods();
        list = methods.addTask("Assignment4", "2021-07-11", list);
        //expected = methods.parse(ListTest.json);
    }

}