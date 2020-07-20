package wolox.training;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import wolox.training.models.Book;
import wolox.training.repositories.BookRepository;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryIntegrationTest {

    @Autowired
    private BookRepository bookRepository;
    private Book oneTestBook;

    @Before
    public void SetUp() {
        oneTestBook = new Book(
                "1234",
                "Song of ice and fire",
                "G.R.Martin",
                "Fantasy",
                "A Game of Thrones",
                "inset image",
                "Bantam books",
                1998
        );
        bookRepository.save(oneTestBook);
    }

    @Test
    public void whenGetBook_thenBookIsPersisted() {
        Book persistedBook = bookRepository.findByTitle("Song of ice and fire")
                .orElse(new Book());
        assertTrue(persistedBook.getTitle()
                .equals(oneTestBook.getTitle()));
        assertTrue(persistedBook.getIsbn()
                .equals(oneTestBook.getIsbn()));
        assertTrue(persistedBook.getAuthor()
                .equals(oneTestBook.getAuthor()));
        assertTrue(persistedBook.getGenre()
                .equals(oneTestBook.getGenre()));
        assertTrue(persistedBook.getSubtitle()
                .equals(oneTestBook.getSubtitle()));
        assertTrue(persistedBook.getImage()
                .equals(oneTestBook.getImage()));
        assertTrue(persistedBook.getPublisher()
                .equals(oneTestBook.getPublisher()));
        assertTrue(persistedBook.getYear() == (oneTestBook.getYear()));
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateBookWithoutTitle_thenTrowException() {
        oneTestBook.setTitle(null);
    }
}
