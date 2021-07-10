/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Karina Narotam
 */

package ucf.assignments;
import javafx.collections.ObservableList;

public class ToDoList {

        private ObservableList<ToDo> myList;

        public ToDoList(ObservableList<ToDo> myList) {
                this.myList = myList;
        }

        public ObservableList<ToDo> getMyList() {
                return myList;
        }

        public void setMyList(ObservableList<ToDo> myList) {
                this.myList = myList;
        }
}
