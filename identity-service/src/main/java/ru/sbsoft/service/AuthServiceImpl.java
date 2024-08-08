package ru.sbsoft.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sbsoft.entity.MdmRight;
import ru.sbsoft.entity.MdmRoleView;
import ru.sbsoft.repository.MdmRoleRepository;
import ru.sbsoft.repository.MdmRoleViewRepository;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtService jwtService;
    private final MdmRoleViewRepository roleViewRepository;
    private final MdmRoleRepository roleRepository;

    @Override
    public String generateToken(String username, List<String> roles) {
        return jwtService.generateToken(username, roles);
    }

    @Override
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getRoles(String username) {
        return roleViewRepository.findByLogin(username).stream().map(MdmRoleView::getRole).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getRightsByRoles(List<String> roles) {
        val set = roleRepository.getRolesByCodeIn(roles).stream()
                .flatMap(role -> role.getRights().stream().map(MdmRight::getCode)).collect(Collectors.toCollection(HashSet::new));
        return set.stream().toList();
    }


}
