
package ar.com.backend.argentinaprograma.api.backend.Repositories;

import ar.com.backend.argentinaprograma.api.backend.Models.Usuario;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long>{
    public Optional<Usuario> findByUsernameOrEmail(String username, String email);
}
