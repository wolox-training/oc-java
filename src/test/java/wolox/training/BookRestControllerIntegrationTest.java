package wolox.training;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import wolox.training.controllers.BookController;
import wolox.training.models.Book;
import wolox.training.repositories.BookRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BookController.class)
public class BookRestControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookRepository mockBookRepository;
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
    }


    @Test
    public void whenFindByIdWhichExist_thenBookIsReturned() throws Exception {
        Mockito.when(mockBookRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(oneTestBook));
        String url = ("api/book/1");
        mvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

