package ru.sbsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbsoft.entity.MdmUser;

import java.util.Optional;

public interface MdmUserRepository extends JpaRepository<MdmUser, Long> {
    Optional<MdmUser> findByLogin(String login);
}
