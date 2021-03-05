package br.org.adfego.cadastro.model.entity;

import lombok.*;

import javax.persistence.*;

/**
 *
 * Profissão do associado
 *
 */

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Profession {
    @Id
    @Column()
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column()
    private String name;

    @Column()
    private Integer CBO;

}
