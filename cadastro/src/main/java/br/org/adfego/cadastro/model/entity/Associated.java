package br.org.adfego.cadastro.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collection;

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
    public Associated(Long id, String name, Boolean situacao, Boolean dependent) {
        super();
        this.situacao = situacao;
        this.dependent = dependent;
    }


}
