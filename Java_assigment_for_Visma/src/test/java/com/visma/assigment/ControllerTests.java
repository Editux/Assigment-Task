package com.visma.assigment;

import com.visma.assigment.controller.BookController;
import com.visma.assigment.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;



import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AssigmentApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;
    @Test
    public void contextLoads() {

    }

    private String getRootUrl() {
        return "http://localhost:" + port;
    }


    @Test
    public void testGetAllBooks() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/books/list",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }
    @Test
    public void testGetBookByGUID() {
        Book book = restTemplate.getForObject(getRootUrl() + "books/3", Book.class);

        assertNotNull(book);
    }
    @Test
    public void testFilterBookByName() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "books/filterByName/Ha",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());

    }
    @Test
    public void testFilterBookByAuthor() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "books/filterByAuthor/J",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());

    }
    @Test
    public void testFilterBookByCategory() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "books/filterByCategory/Fantasy",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());

    }
    @Test
    public void testFilterBookByLanguage() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "books/filterByLanguage/English",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());

    }
    @Test
    public void testFilterBookByISBN() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "books/filterByISBN/9780307278739",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());

    }




}
