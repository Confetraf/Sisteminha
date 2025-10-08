package br.org.confetraf.entity.pessoa;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.org.confetraf.entity.Auditable;
import br.org.confetraf.entity.converters.NomePessoaConverter;
import br.org.confetraf.entity.documento.Documento;
import br.org.confetraf.entity.endereco.Endereco;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "tb_pes")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa extends Auditable implements Serializable {

	private static final long serialVersionUID = 7306838209828688352L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pes_seq")
	@SequenceGenerator(name = "pes_seq", sequenceName = "pes_seq", allocationSize = 50)
	private Long pes_id;

	@Convert(converter = NomePessoaConverter.class)
	@Column(name = "pes_nom", nullable = false, length = 100)
	protected NomePessoa nome;

	@Column(name = "pes_nasc_fund_dt", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDate dataNascimentoFundação;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Documento> documentos;

	@ManyToMany(mappedBy = "pessoas")
	private Set<Endereco> enderecos = new HashSet<>();

}
