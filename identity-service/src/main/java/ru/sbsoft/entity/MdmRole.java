package ru.sbsoft.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(schema = "smdm", name = "MDM_CL_ROLE")
@Data
@NoArgsConstructor
@NamedEntityGraph(name = "roleWithRights", attributeNodes = @NamedAttributeNode("rights"))
public class MdmRole {

    private static final String ID_GEN_NAME = "ADM_DICT_SEQ";

    @Id
    @SequenceGenerator(name = ID_GEN_NAME, sequenceName = "SYS_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ID_GEN_NAME)
    private Long id;

    @Column(name = "code_value", nullable = false, length = 100)
    private String code;

    @Column(name = "name_value", nullable = false, length = 500)
    private String name;

    @Column(name = "notes")
    private String note;

    @JoinTable(schema = "smdm", name = "MDM_CL_ROLERIGHT",
            joinColumns = @JoinColumn(name = "ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "RIGHT_ID"))
    @ManyToMany
    private List<MdmRight> rights;


}
