package wolox.training.models;

import com.google.common.base.Preconditions;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@ApiModel(description = "Books from the OpenLibraryAPI")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column()
    @ApiModelProperty(notes = "The book genre could be: drama, horror, comedy, etc.")
    private String genre;

    @Column(nullable = false)
    private String subtitle;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private int year;

    @ManyToMany(mappedBy = "books")
    private List<Users> users = new ArrayList<>();


    public Book() {
    }

    public Book(long id) {
        this.id = id;
    }

    public Book(String isbn, String title, String author, String genre, String subtitle, String image, String publisher, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.subtitle = subtitle;
        this.image = image;
        this.publisher = publisher;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        Preconditions.checkNotNull(isbn, "Please check the Object supplied, its null!");
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        Preconditions.checkNotNull(title, "Please check the Object supplied, its null!");
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        Preconditions.checkNotNull(author, "Please check the Object supplied, its null!");
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        Preconditions.checkNotNull(subtitle, "Please check the Object supplied, its null!");
        this.subtitle = subtitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        Preconditions.checkNotNull(image, "Please check the Object supplied, its null!");
        this.image = image;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        Preconditions.checkNotNull(publisher, "Please check the Object supplied, its null!");
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        Preconditions.checkNotNull(author, "Please check the Object supplied, its null!");
        this.year = year;
    }

}
