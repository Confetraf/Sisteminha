package br.org.confetraf.entity.pessoa;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.org.confetraf.entity.endereco.Endereco;
import br.org.confetraf.entity.pessoa.documento.Documento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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

@Entity
@Table(name = "tb_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = 7306838209828688352L;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pes_seq")
	@SequenceGenerator(name = "pes_seq", sequenceName = "pes_seq", allocationSize = 50)
	private Long pes_id;

	@Column(name = "pes_nome", nullable = false, length = 100)
	private String nome;

	@Column(name = "pes_dat_nasc_fundacao", nullable = false, columnDefinition = "DATETIME")
	private LocalDate dataNascimentoFundação;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Documento> documentos;
	
	@ManyToMany(mappedBy = "pessoas")
    private Set<Endereco> enderecos = new HashSet<>();


}
