package wolox.training.services;

import org.springframework.stereotype.Service;

@Service
public class OpenLibraryService {

   /* RestTemplate restTemplate = new RestTemplate();
    String openLibraryUrl
            = "https://openlibrary.org/api/books?bibkeys=ISBN:"; //PREGUNTAR: como le concateno lo del final de la url
    ResponseEntity<Book> response
            = restTemplate.getForEntity(openLibraryUrl + "/{isbn}", Book.class);
    assertThat(response.getStatusCode(),equalTo(HttpStatus.OK));



    BookDTO book = restTemplate
            .getForObject(openLibraryUrl + "/{isbn}", BookDTO.class);
    assertThat(book.getTitle(),notNullValue());

    assertThat(book.getSubtitle(),is(1L));

    */


    //ModelMapper modelMapper = new ModelMapper();
    //BookDTO bookDTO = modelMapper.map(book, BookDTO.class);


}
