package br.org.adfego.cadastro.model.entity;

import br.org.adfego.cadastro.model.enums.PhoneType;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Phone {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column()
    private Integer code;

    @Column()
    private String number;

    @Column()
    @Enumerated(value = EnumType.STRING)
    private PhoneType phoneType;
}
