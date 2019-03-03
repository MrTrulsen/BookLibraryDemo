package no.ntnu.sysdev.spring_demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    private int id;
    private String author;
    private String title;

    //Could do both her, chose JsonCreator because of constructor error.
    //public Book() {
    //    super();
    //}


    @JsonCreator
    public Book(@JsonProperty("author") String author, @JsonProperty("title") String title, @JsonProperty("id") int id) {
        this.author = author;
        this.title = title;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }






}
