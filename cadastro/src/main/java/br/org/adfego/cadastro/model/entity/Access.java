package br.org.adfego.cadastro.model.entity;

import br.org.adfego.cadastro.model.enums.PhoneType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Access {
    @Id
    @Column()
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(length = 20)
    @Size(min = 2, max = 20, message = "Login deve ter entre 2 e 20 caracteres")
    private String login;

    @Column(length = 20)
    @Size(min = 6, max = 10, message = "A senha deve ter entre 6 e 20 caracteres")
    private String senha;

    @OneToOne
    @JoinColumn(name = "associated_id")
    private Associated associated;
}
