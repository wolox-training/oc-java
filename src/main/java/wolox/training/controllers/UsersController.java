package wolox.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wolox.training.exceptions.BookIdMismatchException;
import wolox.training.exceptions.BookNotFoundException;
import wolox.training.models.Users;
import wolox.training.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public Iterable findAll() {
        return usersRepository.findAll();
    }

    @GetMapping("/username/{userName}")
    public List findByName(@PathVariable String username) {
        return usersRepository.findByName(username);
    }

    @GetMapping("/{id}")
    public Optional<Users> findOne(@PathVariable Long id) {
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
                .orElseThrow(() -> new BookNotFoundException("error user"));
        usersRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Users updateUsers(@RequestBody Users users, @PathVariable Long id) {
        if (users.getId() != id) {
            throw new BookIdMismatchException();
        }
        usersRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("error user"));
        return usersRepository.save(users);
    }


}
