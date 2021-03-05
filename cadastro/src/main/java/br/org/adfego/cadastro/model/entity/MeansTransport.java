package br.org.adfego.cadastro.model.entity;

import lombok.*;

import javax.persistence.*;

/**
 *
 * Meios de transporte do associado - carro, moto,
 *
 */

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class MeansTransport {
    @Id
    @Column()
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column()
    private String name;

}
