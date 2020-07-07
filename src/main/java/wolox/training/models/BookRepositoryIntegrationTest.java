package wolox.training.models;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import wolox.training.repositories.BookRepository;

@DataJpaTest
public class BookRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void whenFindByTitle_thenReturnBook() {
        // given
        Book theBook = new Book(1);
        entityManager.persist(theBook);
        entityManager.flush();

        // when
        Book found = bookRepository.findByTitle(theBook.getTitle());

        // then
        assertThat(found.getTitle())
                .isEqualTo(theBook.getTitle());
    }

}
