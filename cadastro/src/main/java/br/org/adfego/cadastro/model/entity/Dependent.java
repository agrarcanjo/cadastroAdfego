package br.org.adfego.cadastro.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * Relaciona o associado com um dependente e cria como é esse tipo de dependência
 *
 * @author agrarcanjo
 *
 */

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Dependent {
    @Id
    @Column()
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column()
    private String name;

    @Column()
    private String note;

    @ManyToOne
    @JoinColumn(name = "associated_id")
    @NotNull(message = "O Associado deve ser preenchido")
    private Associated user;

}
