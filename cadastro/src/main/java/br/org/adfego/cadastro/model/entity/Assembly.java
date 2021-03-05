package br.org.adfego.cadastro.model.entity;

import lombok.*;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Assembleias realizadas pela adfego
 *
 */

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Assembly {
    @Id
    @Column()
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(length = 50)
    @Size(min = 2, max = 50, message = "O título deve ter entre 2 a 50 caracteres")
    private String title;

    @Column()
    private Character active;

    @Column()
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate updateDate;

    @Column()
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate registerDate;

}
