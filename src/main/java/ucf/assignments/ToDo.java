/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Karina Narotam
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.time.LocalDate;

/*
    Code generate getters, setters, constructor for To-Do class
 */

public class ToDo {
    private SimpleStringProperty item, description;
    private LocalDate date;
    private boolean complete = false;

    public ToDo(String item, String description, LocalDate date) {
        this.item = new SimpleStringProperty(item);
        this.description = new SimpleStringProperty(description);
        this.date = date;
    }

    public String getItem() {
        return item.get();
    }

    public StringProperty itemProperty() {
        return item;
    }

    public void setItem(String item) {
        this.item.set(item);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
