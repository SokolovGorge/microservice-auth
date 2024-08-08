package ru.sbsoft.books.client;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IdentityServiceClient implements IdentityService {

    private final RestTemplate restTemplate;

    @Override
    public List<String> getRightsByRoles(List<String> roles) {
        val params = String.join("&&", roles.stream().map(role -> "roles=" + role).collect(Collectors.toList()));
        return restTemplate.getForObject("http://IDENTITY-SERVICE/auth/rights?" + params, List.class);
    }
}
