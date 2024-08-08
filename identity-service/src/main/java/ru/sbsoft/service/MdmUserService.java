package ru.sbsoft.service;


import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sbsoft.repository.MdmUserRepository;

@Service
@RequiredArgsConstructor
public class MdmUserService implements UserDetailsService {

    private final MdmUserRepository userRepository;
//    private final MdmRoleViewRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        val user = userRepository.findByLogin(username);
        if (!user.isPresent() || !user.get().isEnabled()) {
            throw new UsernameNotFoundException(username);
        }
//        val roles = roleRepository.findByLogin(username);
        return User.withUsername(user.get().getLogin())
                .password(user.get().getPasswd())
//                .authorities(roles.stream().map(role -> role.getRole()).collect(Collectors.toList()).toArray(new String[0]))
                .build();
    }
}
