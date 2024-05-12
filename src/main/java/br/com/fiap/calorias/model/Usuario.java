package br.com.fiap.calorias.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="SEQ_USUARIOS"
    )
    @SequenceGenerator(
            name="SEQ_USUARIOS",
            sequenceName="SEQ_USUARIOS",
            allocationSize = 1
    )
    //@Column(name = "USUARIO_ID")
    private Long usuarioId;

    private String nome;
    private String email;
    private String senha;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;
}
