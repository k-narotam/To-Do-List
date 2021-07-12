/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Karina Narotam
 */

package ucf.assignments;
/*
    Used for serializing array list for file parsing
 */

public class ArrayToDo {
    private String description, dateString;

    public ArrayToDo(String description, String dateString) {
        this.description = description;
        this.dateString = dateString;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

}
