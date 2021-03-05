package br.org.adfego.cadastro.model.entity;

import lombok.*;

import javax.persistence.*;

/**
 *
 * Tipo de Residência do associado
 *
 */

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Residence {
    @Id
    @Column()
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column()
    private String name;

}
