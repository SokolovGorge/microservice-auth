package ru.sbsoft.repository;

import org.springframework.data.repository.Repository;
import ru.sbsoft.entity.MdmRoleView;

import java.util.List;

public interface MdmRoleViewRepository extends Repository<MdmRoleView, String> {

    List<MdmRoleView> findByLogin(String login);
}
