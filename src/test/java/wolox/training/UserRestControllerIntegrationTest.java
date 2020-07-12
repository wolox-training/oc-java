package wolox.training;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import wolox.training.controllers.UsersController;
import wolox.training.models.Book;
import wolox.training.models.Users;
import wolox.training.repositories.UsersRepository;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsersController.class)
public class UserRestControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UsersRepository mockUserRepository;
    private Users oneTestUser;
    private Book oneTestBook;

    @Before
    public void SetUp() {
        oneTestBook = new Book();
        oneTestBook.setIsbn("1234");
        oneTestBook.setAuthor("G.R.Martin");
        oneTestBook.setTitle("Song of ice and fire");
        oneTestBook.setSubtitle("A Game of Thrones");
        oneTestBook.setGenre("Fantasy");
        oneTestBook.setImage("insert image");
        oneTestBook.setPublisher("Bantam books");
        oneTestBook.setYear(1998);
        oneTestUser = new Users();
        oneTestUser.setUsername("ocolmenares");
        oneTestUser.setName("Oriana");
        oneTestUser.setBirthday(LocalDate.parse("1997-11-03"));
        oneTestUser.addBooks(oneTestBook);
    }


    @Test
    public void whenFindByIdWhichExist_thenUserIsReturned() throws Exception {
        Mockito.when(mockUserRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(oneTestUser));
        String url = ("api/users/1");
        mvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
