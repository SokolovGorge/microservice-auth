package ru.sbsoft.service;

import java.util.List;

public interface AuthService {

    String generateToken(String username, List<String> roles);

    void validateToken(String token);

    List<String> getRoles(String username);

    List<String> getRightsByRoles(List<String> roles);
}
