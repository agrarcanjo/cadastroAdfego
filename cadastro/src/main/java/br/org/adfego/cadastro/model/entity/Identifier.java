package br.org.adfego.cadastro.model.entity;


import br.org.adfego.cadastro.model.enums.IdendifierType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
public class Identifier {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(length = 12)
    @NotBlank(message = "O identificador deve ser preenchido")
    @Size(min = 2, max = 12, message = "O identificador deve ter entre 2 e 12 letras")
    private String number;

    @Column()
    private String complement;

    @Column()
    @Enumerated(value = EnumType.STRING)
    private IdendifierType idendifierType;

    @ManyToOne
    @JoinColumn(name = "associated_id")
    private Associated associated;

    @Builder
    public Identifier(Long id, String number, String complement, IdendifierType idendifierType, Associated associated){
        this.id = id;
        this.number = number;
        this.complement = complement;
        this.idendifierType = idendifierType;
        this.associated = associated;
    }

    public Identifier() {}
}
