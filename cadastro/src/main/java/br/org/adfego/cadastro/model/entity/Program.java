package br.org.adfego.cadastro.model.entity;

import lombok.*;

import javax.persistence.*;

/**
 *
 * Programa em que o associado se encontra
 *
 */

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Program {
    @Id
    @Column()
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column()
    private String name;

}
