package wolox.training.dtos;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookDTO {
    private String isbn;
    private String title;
    private String subtitle;
    private String publisher;
    private LocalDate publishDate;
    private int numberOfPages;
    private ArrayList<List> authors;

    public BookDTO() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public ArrayList<List> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<List> authors) {
        this.authors = authors;
    }
}
