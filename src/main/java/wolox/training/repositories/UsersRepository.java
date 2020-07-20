package wolox.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wolox.training.models.Users;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);

    List<Users> findFirstByUsername(String username);

}
