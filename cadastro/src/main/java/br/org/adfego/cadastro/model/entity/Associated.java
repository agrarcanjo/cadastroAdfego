package br.org.adfego.cadastro.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Associated extends User {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "A situação do associado deve estar ativa ou desativado")
    private Boolean situacao;

    @NotNull(message = "O associado é dependente ou não")
    private Boolean dependent;

    @OneToMany(mappedBy = "associated", cascade = CascadeType.ALL, orphanRemoval = true, fetch= FetchType.LAZY)
    private Collection<Identifier> identifiers = new ArrayList<>();

    @OneToMany(mappedBy = "associated", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<DeficiencyAssociated> deficiencyAssociateds = new ArrayList<>();

    @Builder
    public Associated(Long id, String name, String email, String dadName, String momName, Character genre,  CivilStatus civilStatus, Profession profession, Boolean situacao, Date birthDate, Boolean dependent, Collection<Identifier> identifiers, Collection<DeficiencyAssociated> deficiencyAssociateds) {
        super(id, name, email, dadName, momName, genre, civilStatus, profession, birthDate);
        this.situacao = situacao;
        this.dependent = dependent;
        this.identifiers = identifiers;
        this.deficiencyAssociateds = deficiencyAssociateds;
    }


}
