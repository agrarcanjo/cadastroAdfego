package br.org.adfego.cadastro.model.entity;

import br.org.adfego.cadastro.model.enums.Situation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Associated extends User {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "A situação do associado deve estar ativa ou desativado")
    @Digits(integer=1, fraction=0, message = "A situação do associado deve ser preenchido com um valor inteiro")
    private Integer situation;

    @ManyToOne
    @JoinColumn(name = "means_locomotion_id")
    private MeansLocomotion meansLocomotion;

    @ManyToOne
    @JoinColumn(name = "means_transport_id")
    private MeansTransport meansTransport;

    @ManyToOne
    @JoinColumn(name = "residence_id")
    private Residence residence;

    @ManyToOne
    @JoinColumn(name = "schooling_id")
    private Schooling schooling;

    @Column()
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date death;

    @OneToMany(mappedBy = "associated", cascade = CascadeType.ALL, orphanRemoval = true, fetch= FetchType.EAGER)
    private Collection<Identifier> identifiers = new ArrayList<>();

    @OneToMany(mappedBy = "associated", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<DeficiencyAssociated> deficiencyAssociateds = new ArrayList<>();

    @OneToMany(mappedBy = "associated", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<Dependent> dependent = new ArrayList<>();


    @Builder
    public Associated(Long id, String name, String email, String dadName, String momName, Character genre, CivilStatus civilStatus, Profession profession, Situation situation, Date birthDate, List<Identifier> identifiers) {
        super(id, name, email, dadName, momName, genre, civilStatus, profession, birthDate);
        this.situation =  (situation==null) ? null : situation.getCod();;
        this.identifiers = identifiers;
    }

    public Situation getSituation() {
        return Situation.toEnum(situation);
    }

    public void setSituation(Situation situation) {
        this.situation = situation.getCod();
    }

}
