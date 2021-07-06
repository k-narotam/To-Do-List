/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Karina Narotam
 */

package ucf.assignments;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import java.time.LocalDate;

/*
    Code generate getters, setters, constructor for To-Do class
 */

public class ToDo {
    private StringProperty item, description;
    private LocalDate date;
    private BooleanProperty complete;

    public ToDo(StringProperty item, StringProperty description, LocalDate date, BooleanProperty complete) {
        this.item = item;
        this.description = description;
        this.date = date;
        this.complete = complete;
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

    public boolean isComplete() {
        return complete.get();
    }

    public BooleanProperty completeProperty() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete.set(complete);
    }
}
