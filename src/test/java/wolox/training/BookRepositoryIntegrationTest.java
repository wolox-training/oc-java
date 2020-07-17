package wolox.training;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import wolox.training.models.Book;
import wolox.training.repositories.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;
    private Book oneTestBook;

    @Before
    public void SetUp() {
        oneTestBook = new Book();
        oneTestBook.setTitle("Harry Potter");
    }

    @Test
    public void whenCreatedBook_thenBookIsPersisted() {
        Book persistedBook = bookRepository.findByTitle("Song of ice and fire")
                .orElse(new Book());
        assertThat(persistedBook.getTitle()
                .equals(oneTestBook.getTitle())).isTrue();

    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateBookWithoutTitle_thenTrowException() {
        oneTestBook.setTitle(null);
        bookRepository.save(oneTestBook);
    }
}
