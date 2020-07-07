package wolox.training.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import wolox.training.models.Book;
import wolox.training.repositories.BookRepository;


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
        Mockito.when(mockBookRepository.findById(1L)).thenReturn(oneTestBook);
        String url = ("api/book/1");
        mvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON));
            .andExpect(status().isOk());
            .andExpect(content().json(
                "{\"id\":0,\"author\":\"G.R.Martin\",\"title\":\"Song of ice and fire\",\"subtitle\":\"A Game of Thrones\","
                        + "\"genre\":\"Fantasy\",\"image\":\"insert image\",\"publisher\":\"Bantam books\",\"year\":\"1998}"
        ));

    }
}

