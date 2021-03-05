package br.org.adfego.cadastro.model.entity;

import br.org.adfego.cadastro.model.enums.Situation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public abstract class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column()
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column()
	@NotBlank(message = "Nome da Pessoa deve ser preenchido")
	@Size(min = 2, max = 50, message = "Nome da Pessoa deve ter entre 2 e 50 letras")
	private String name;

	@Column()
	@Size(min = 2, max = 100, message = "O email deve ter entre 2 e 100 letras")
	private String email;

	@Column()
	@Size(min = 2, max = 50, message = "Nome do pai deve ter entre 2 e 50 letras")
	private String dadName;

	@Column()
	@Size(min = 2, max = 50, message = "Nome da mãe deve ter entre 2 e 50 letras")
	private String momName;

	@Column()
	private Character genre;

	@OneToOne
	@JoinColumn(name = "civil_status_id")
	private CivilStatus civilStatus;

	@OneToOne
	@JoinColumn(name = "profession_id")
	private Profession profession;

	@OneToMany
	@JoinColumn(name = "phones_id")
	private List<Phone> phones;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adress_id")
	private Adress adress;

	@Column()
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;

	@Column()
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate updateDate;

	@Column()
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate registerDate;

}
