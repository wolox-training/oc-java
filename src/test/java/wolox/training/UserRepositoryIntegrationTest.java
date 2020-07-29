package wolox.training;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import wolox.training.models.Book;
import wolox.training.models.Users;
import wolox.training.repositories.BookRepository;
import wolox.training.repositories.UsersRepository;

import java.time.LocalDate;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BookRepository bookRepository;

    private Users oneTestUser;
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
        oneTestUser = new Users(
                "ocolmenares",
                "Oriana",
                "password",
                LocalDate.parse("1997-11-03")
        );
        oneTestUser.addBook(oneTestBook);

        bookRepository.save(oneTestBook);
        usersRepository.save(oneTestUser);
    }

    @Test
    public void whenGetUser_thenUserIsPersisted() {
        Users persistedUsers = usersRepository.findByUsername("ocolmenares")
                .orElse(new Users());
        assertTrue(persistedUsers.getUsername()
                .equals(oneTestUser.getUsername()));
        assertTrue(persistedUsers.getName()
                .equals(oneTestUser.getName()));
        assertTrue(persistedUsers.getBirthday()
                .equals(oneTestUser.getBirthday()));
        assertTrue(persistedUsers.getBooks().size() == oneTestUser.getBooks().size());
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateUserWithoutUsername_thenTrowException() {
        oneTestUser.setUsername(null);
    }
}

