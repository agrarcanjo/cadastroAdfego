package br.org.adfego.cadastro.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * Deficiencias do associado com CID, Data do incidente, caudas da deficiência
 *
 */

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class DeficiencyAssociated {
    @Id
    @Column()
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(length = 10)
    private String CID;

    @Column()
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date incidentDate;

    @Column(length = 100)
    private String deficiencyTail;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "associated_id")
    private Associated associated;
}
