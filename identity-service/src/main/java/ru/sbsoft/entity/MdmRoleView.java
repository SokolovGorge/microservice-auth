package ru.sbsoft.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "smdm", name = "MDM_USER_ROLE_VIEW2")
@Data
@NoArgsConstructor
public class MdmRoleView {

    @Id
    private String id;

    private String login;

    @Column(name = "ROLE_CODE")
    private String role;

}
