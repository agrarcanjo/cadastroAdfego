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
public class Adress {
    @Id
    @Column()
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(length = 50)
    @Size(min = 2, max = 50, message = "O logradouro deve ter entre 2 a 50 caracteres")
    private String logradouro;

    @Column(length = 10)
    @Size(min = 6, max = 10, message = "O cep deve ter entre 6 a 10 caracteres")
    private String cep;

    @Column(length = 50)
    @Size(min = 2, max = 50, message = "O bairro deve ter entre 2 a 50 caracteres")
    private String bairro;

    //TODO
    @Column(length = 50)
    @Size(min = 2, max = 50, message = "A cidade deve ter entre 2 a 50 caracteres")
    private String city;

    @Column()
    @Enumerated(value = EnumType.STRING)
    private PhoneType phoneType;

    @ManyToOne
    @JoinColumn(name = "associated_id")
    private Associated associated;
}
