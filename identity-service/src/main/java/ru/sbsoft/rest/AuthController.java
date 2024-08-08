package ru.sbsoft.rest;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import ru.sbsoft.dto.AuthRequestData;
import ru.sbsoft.service.AuthService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final AuthService authService;


    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequestData authRequestData) {
        val authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestData.getUsername(), authRequestData.getPassword()));
        if (authenticate.isAuthenticated()) {
            val username = ((User) authenticate.getPrincipal()).getUsername();
            return authService.generateToken(username, authService.getRoles(username));
        } else {
            throw new BadCredentialsException("Невалидный доступ");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        authService.validateToken(token);
        return "Токен валиден";
    }

    @GetMapping("/rights")
    public List<String> getRights(@RequestParam("roles") String[] roles) {
        return authService.getRightsByRoles(Arrays.asList(roles));
    }
}
