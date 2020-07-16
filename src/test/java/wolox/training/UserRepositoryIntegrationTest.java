package wolox.training;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import wolox.training.models.Book;
import wolox.training.models.Users;
import wolox.training.repositories.UsersRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UsersRepository usersRepository;

    private Users oneTestUser;
    private Book oneTestBook;

    @Before
    public void SetUp() {
       /* oneTestBook = new Book(
                "1234",
                "Song of ice and fire",
                "G.R.Martin",
                "Fantasy",
                "A Game of Thrones",
                "inset image",
                "Bantam books",
                1998
        );
        oneTestUser = new Users();
        oneTestUser.setUsername("ocolmenares");
        oneTestUser.setName("Oriana");
        oneTestUser.setBirthday(LocalDate.parse("1997-11-03"));
        oneTestUser.addBook(oneTestBook);

        */
    }

    @Test
    public void whenCreatedUser_thenUserIsPersisted() {
        System.out.println("Empieza el test");
       /* Users persistedUsers = usersRepository.findFirstByUsername("ocolmenares")
                .orElse(new Users());
        assertThat(persistedUsers.getUsername()
                .equals(oneTestUser.getUsername())).isTrue();
        assertThat(persistedUsers.getName()
                .equals(oneTestUser.getName())).isTrue();
        assertThat(persistedUsers.getBirthday()
                .equals(oneTestUser.getBirthday())).isTrue();
        assertThat(persistedUsers.getBooks().size() == oneTestUser.getBooks().size()).isTrue();
        usersRepository.save(oneTestUser);

        */
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateUserWithoutUsername_thenTrowException() {
        oneTestUser.setUsername(null);
        usersRepository.save(oneTestUser);
    }
}

