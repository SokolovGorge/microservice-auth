package ru.sbsoft.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbsoft.entity.MdmRole;


import java.util.List;

public interface MdmRoleRepository extends JpaRepository<MdmRole, Long> {

    @EntityGraph(value = "roleWithRights")
    List<MdmRole> getRolesByCodeIn(List<String> code);
}
