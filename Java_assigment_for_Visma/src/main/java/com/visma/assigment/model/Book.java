package com.visma.assigment.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

public class Book {
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Author")
    private String author;
    @JsonProperty("Category")
    private String category;
    @JsonProperty("Language")
    private String language;
    @JsonProperty("Publication date")
    private String publication_date;


    @JsonProperty("ISBN")
    private String isbn;


    @JsonProperty("GUID")
    private String guid;

    public Book (){ };
    public Book(String name,String author,String category,String language,String publication_date,String isbn,String guid){
        this.name= name;
        this.author=author;
        this.category=category;
        this.language=language;
        this.publication_date=publication_date;
        this.isbn=isbn;
        this.guid=guid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    public String getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

}
