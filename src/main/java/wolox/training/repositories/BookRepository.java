package wolox.training.repositories;

import org.springframework.data.repository.CrudRepository;
import wolox.training.models.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
