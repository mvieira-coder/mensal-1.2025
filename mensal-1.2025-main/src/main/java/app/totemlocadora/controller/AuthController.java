package app.totemlocadora.controller;

import app.totemlocadora.dto.LoginDTO;
import app.totemlocadora.dto.TokenDTO;
import app.totemlocadora.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired private AuthenticationManager authManager;
    @Autowired private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        try {
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
            Authentication auth = authManager.authenticate(token);
            UserDetails user = (UserDetails) auth.getPrincipal();
            String jwt = jwtService.gerarToken(user);
            return ResponseEntity.ok(new TokenDTO(jwt));
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(401).body("Credenciais invalidas");
        }
    }
}
