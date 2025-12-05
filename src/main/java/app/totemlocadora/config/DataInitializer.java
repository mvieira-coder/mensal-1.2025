package app.totemlocadora.config;

import app.totemlocadora.model.Usuario;
import app.totemlocadora.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void run(String... args) {

        if (repo.findByUsername("admin").isEmpty()) {
            Usuario u = new Usuario();
            u.setUsername("admin");
            u.setPassword(encoder.encode("admin123"));
            u.setRole("ROLE_ADMIN");
            repo.save(u);
        }

        if (repo.findByUsername("user").isEmpty()) {
            Usuario u = new Usuario();
            u.setUsername("user");
            u.setPassword(encoder.encode("user123"));
            u.setRole("ROLE_USER");
            repo.save(u);
        }
    }
}
