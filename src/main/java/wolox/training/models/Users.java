package wolox.training.models;

import com.google.common.base.Preconditions;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthday;

    @ManyToMany(targetEntity = Book.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_books",
            joinColumns = {@JoinColumn(name = "USERS_ID")},
            inverseJoinColumns = {@JoinColumn(name = "BOOK_ID")}
    )
    private List<Book> books = new ArrayList<>();

    public Users() {
    }

    public Users(long id) {
        this.id = id;
        this.books = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        Preconditions.checkNotNull(username, "Please check the USERNAME!!!!! supplied, its null!");
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Preconditions.checkNotNull(name, "Please check the Object supplied, its null!");
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        Preconditions.checkNotNull(birthday, "Please check the Object supplied, its null!");
        this.birthday = birthday;
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }
}
