package br.org.adfego.cadastro.model.entity;

import lombok.*;

import javax.persistence.*;

/**
 * renda pessoal do associado
 *
 */

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Income {
    @Id
    @Column()
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column()
    private String valueRange;

}
