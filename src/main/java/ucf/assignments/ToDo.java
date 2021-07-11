/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Karina Narotam
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
    Code generate getters, setters, constructor for To-Do class
 */

public class ToDo {
    private SimpleStringProperty description, dateString;
    private CheckBox select;

    public ToDo(String description, String dateString) {
        this.description = new SimpleStringProperty(description);
        this.dateString = new SimpleStringProperty(dateString);
        this.select = new CheckBox();
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }

    public String getDateString() {
        return dateString.get();
    }

    public void setDateString(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        this.dateString = new SimpleStringProperty(date.toString());
        //this.dateString = new SimpleStringProperty(dateString);
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox select) {
        this.select = select;
    }

}
