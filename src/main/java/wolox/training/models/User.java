package wolox.training.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthday;
    // PREGUNTAR: Cómo es el uso del one to one en este caso que solo estaria en el User ya que Books no tiene users, para combinar la tabla Books en esta.
    private List<Book> books = new ArrayList<>();

    public User(long id) {
        this.id = id;
    }

    // PREGUNTAR: Debería books llevar un setter también ? "ya que luego será cargado automáticamente cuando se levante de la base de datos"
    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
