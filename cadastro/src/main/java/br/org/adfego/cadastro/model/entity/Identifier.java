package br.org.adfego.cadastro.model.entity;


import br.org.adfego.cadastro.model.enums.IdendifierType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @Digits(integer=1, fraction=0, message = "O tipo do identificador deve ser preenchido com um valor inteiro")
    private Integer idendifierType;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "associated_id")
    private Associated associated;

    @Builder
    public Identifier(Long id, String number, String complement, IdendifierType idendifierType, Associated associated){
        this.id = id;
        this.number = number;
        this.complement = complement;
        this.idendifierType = (idendifierType==null) ? null : idendifierType.getCod();;
        this.associated = associated;
    }

    public IdendifierType getIdendifierType() {
        return IdendifierType.toEnum(idendifierType);
    }

    public void setIdendifierType(IdendifierType idendifierType) {
        this.idendifierType = idendifierType.getCod();
    }
}
