package ru.sbsoft.books.client;

import java.util.List;

public interface IdentityService {

    List<String> getRightsByRoles(List<String> roles);
}
