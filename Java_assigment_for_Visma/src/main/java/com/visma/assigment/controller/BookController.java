package com.visma.assigment.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.visma.assigment.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

@RestController
@RequestMapping("/books")
public class BookController {



@Autowired
ObjectMapper objectMapper;
    // Get list of books example =/books/list
    @GetMapping("/list")
    Book[] getList() throws IOException {
    Book[] books= objectMapper.readValue(new File("./books.json"), Book[].class);
    return books;
    }
    //Insert book to the list example = /books/insertBook
    //Used synchronised keyword to avoid simultaneous file modification.
    @PostMapping("/insertBook")
    public synchronized void insertBook(@RequestBody Book book) throws IOException, JSONException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get("./books.json");
        final String currentJsonArrayAsString = Files.readString(path);

        try (FileWriter fileWriter = new FileWriter(path.toFile(), false)) {
            JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(book));
            JSONArray jsonArray = new JSONArray(currentJsonArrayAsString);
            jsonArray.put(jsonObject);

            fileWriter.write(jsonArray.toString());
        }
    }
    //Getting a book by GUID example = /books/3
    //Used filter function to get a book by guid
    @RequestMapping("/{guid}")
    public Optional<Book> getBook (@PathVariable String guid) throws IOException {
        Book[] books =objectMapper.readValue(new File("./books.json"), Book[].class);
        return Arrays.stream(books).filter(t->guid.equals(t.getGuid())).findFirst();
    }
    //FilterByName function example= books/filterByName/Ha
    //Since titles of the book contains space I used function filter by starting letters.
    @RequestMapping("filterByName/{name}")
    public Stream<Book> getByName (@PathVariable String name) throws IOException {
        Book[] books =objectMapper.readValue(new File("./books.json"), Book[].class);
        return Arrays.stream(books).filter(t-> t.getName().startsWith(name));
    }
    //FilterByAuthor function example = books/filterByAuthor/J
    @RequestMapping("filterByAuthor/{author}")
    public Stream<Book> getByAuthor (@PathVariable String author) throws IOException {
        Book[] books =objectMapper.readValue(new File("./books.json"), Book[].class);
        return Arrays.stream(books).filter(t->t.getAuthor().startsWith(author));
    }
    //FilterByCategory function example= books/filterByCategory/Fantasy
    @RequestMapping("filterByCategory/{category}")
    public Stream<Book> getByCategory (@PathVariable String category) throws IOException {
        Book[] books =objectMapper.readValue(new File("./books.json"), Book[].class);
        return Arrays.stream(books).filter(t->category.equals(t.getCategory()));
    }
    //FilterByLanguage function example=books/filterByLanguage/English
    @RequestMapping("filterByLanguage/{language}")
    public Stream<Book> getByLanguage (@PathVariable String language) throws IOException {
        Book[] books =objectMapper.readValue(new File("./books.json"), Book[].class);
        return Arrays.stream(books).filter(t->language.equals(t.getLanguage()));
    }
    //FilterByISBN function example=books/filterByISBN/9780307278739
    @RequestMapping("filterByISBN/{isbn}")
    public Stream<Book> getByISBN (@PathVariable String isbn) throws IOException {
        Book[] books =objectMapper.readValue(new File("./books.json"), Book[].class);
        return Arrays.stream(books).filter(t->isbn.equals(t.getIsbn()));
    }



}
