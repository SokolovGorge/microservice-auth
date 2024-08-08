package ru.sbsoft.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(schema = "smdm", name = "MDM_CL_USER")
@Data
@NoArgsConstructor
public class MdmUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_GEN")
    @SequenceGenerator(name = "USER_GEN", sequenceName = "SYS_SEQUENCE", allocationSize = 1)
    private Long id;

    private String login;

    private String passwd;

    @Column(name = "is_enabled")
    private boolean enabled;

    private String surname;

    @Column(name = "fstname")
    private String name;

    @Column(name = "patname")
    private String patronymic;

    private String position;

    private String phone;

    private String email;

    @Temporal(jakarta.persistence.TemporalType.DATE)
    @Column(name = "p_expired")
    private Date passwExpireDate;

}
