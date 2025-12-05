package app.totemlocadora.controller;

import app.totemlocadora.dto.LoginDTO;
import app.totemlocadora.dto.TokenDTO;
import app.totemlocadora.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {

        try {
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
            );

            UserDetails user = (UserDetails) auth.getPrincipal();

            String token = jwtService.gerarToken(user);
            String role = user.getAuthorities().iterator().next().getAuthority();

            return ResponseEntity.ok(
                    new TokenDTO(
                            token,
                            user.getUsername(),
                            role
                    )
            );

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Usuário ou senha inválidos");
        }
    }
}
