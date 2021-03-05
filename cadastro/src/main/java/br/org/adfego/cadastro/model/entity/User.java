package br.org.adfego.cadastro.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

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

	@Column()
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;

	@Column()
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate updateDate;

	@Column()
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate registerDate;

	public User(Long id, String name, String email, String dadName, String momName, Character genre, CivilStatus civilStatus, Profession profession, Date birthDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dadName = dadName;
		this.momName = momName;
		this.genre = genre;
		this.civilStatus = civilStatus;
		this.profession = profession;
		this.birthDate = birthDate;
	}
}
