package wolox.training;


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


    /*@Test
    public void whenCreatedBook_thenBookIsPersisted() {
        Book persistedBook = BookRepository.findByTitle("Song of ice and fire")
                .orElse(new Book());
        assertThat(persistedBook.getTitle()
                .equals(oneTestBook.getTitle())).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateBookWithoutTitle_thenTrowException() {
        Book.setTitle(null);
        bookRepository.save();
    }
    */
}
