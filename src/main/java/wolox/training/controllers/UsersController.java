package wolox.training.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wolox.training.exceptions.BookNotFoundException;
import wolox.training.exceptions.UserIdMismatchException;
import wolox.training.exceptions.UserNotFoundException;
import wolox.training.models.Book;
import wolox.training.models.Users;
import wolox.training.repositories.BookRepository;
import wolox.training.repositories.UsersRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;
    private BookRepository bookRepository;

    @GetMapping
    public Iterable findAll() {
        return usersRepository.findAll();
    }

    @GetMapping("/username/{userName}")
    public Optional<Users> findByUsername(@PathVariable String username) {
        return usersRepository.findByUsername(username);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Giving an id, return the user", response = Users.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not Authorized"),
            @ApiResponse(code = 403, message = "Access forbidden"),
            @ApiResponse(code = 404, message = "User Not Found"),
    })
    public Optional<Users> findOne(@ApiParam(value = "id to find a user", required = true) @PathVariable Long id) {
        return usersRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users create(@RequestBody Users users) {
        return usersRepository.save(users);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usersRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("error user"));
        usersRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Users updateUsers(@RequestBody Users users, @PathVariable Long id) {
        if (users.getId() != id) {
            throw new UserIdMismatchException();
        }
        usersRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("error user"));
        return usersRepository.save(users);
    }

    @PutMapping("users/{id}/addbooks/{bookId} ")
    public void addBooks(@PathVariable Long id, @PathVariable Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("error book no existe"));
        Users users = usersRepository.findById(id).orElseThrow(() -> new UserNotFoundException("error user"));
        users.addBook(book);
        usersRepository.save(users);
    }

    @DeleteMapping("users/{id}/deletebooks/{bookId} ")
    public void deleteBooks(@PathVariable Long id, @PathVariable Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("error book no existe"));
        Users users = usersRepository.findById(id).orElseThrow(() -> new UserNotFoundException("error user"));
        users.removeBook(book);
        usersRepository.save(users);
    }
}