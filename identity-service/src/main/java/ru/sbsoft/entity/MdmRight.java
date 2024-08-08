package ru.sbsoft.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "smdm", name = "MDM_CL_RIGHT")
@Data
@NoArgsConstructor
public class MdmRight {

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

}
