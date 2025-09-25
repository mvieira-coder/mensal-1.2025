package app.totemlocadora.auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200") // sempre minúsculo
public class AuthController {

    public record LoginDTO(String username, String password) {}

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginDTO body) {
        if ("admin".equals(body.username()) && "123".equals(body.password())) {
            return Map.of("token", "fake-jwt-token-123");
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciais inválidas");
    }
}
