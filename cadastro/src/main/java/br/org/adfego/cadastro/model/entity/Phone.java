package br.org.adfego.cadastro.model.entity;

import br.org.adfego.cadastro.model.enums.PhoneType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Phone {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column()
    private Integer code;

    @Column()
    private String number;

    @Digits(integer=1, fraction=0, message = "O tipo de telefone deve ser preenchido com um valor inteiro")
    private Integer phoneType;

    @ManyToOne
    @JoinColumn(name = "associated_id")
    @NotNull(message = "O Associado deve ser preenchido")
    private Associated user;

    @Builder
    public Phone(Long id, Integer code, PhoneType phoneType, String number, Associated user) {
        this.id = id;
        this.user = user;
        this.code = code;
        this.number = number;
        this.phoneType = (phoneType==null) ? null : phoneType.getCod();
    }

    public PhoneType getPhoneType(){ return PhoneType.toEnum(phoneType); }

    public void setPhoneType(PhoneType phoneType){ this.phoneType = phoneType.getCod(); }

}
