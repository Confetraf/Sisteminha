package br.org.confetraf.entity.endereco;

import java.io.Serializable;
import java.util.Set;
import br.org.confetraf.entity.Auditable;
import br.org.confetraf.entity.converters.UnidadeFederativaConverter;
import br.org.confetraf.entity.enums.UnidadeFederativa;
import br.org.confetraf.entity.pessoa.PessoaFisica;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "tb_end_endr")
public class Endereco extends Auditable implements Serializable {

	private static final long serialVersionUID = 7829486780841849335L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endr_seq")
	@SequenceGenerator(name = "endr_seq", sequenceName = "endr_seq", allocationSize = 50)
	private long endr_id;
	
	@ManyToOne
	@JoinColumn(
		    name = "logr_id",
		    nullable = false,
		    foreignKey = @ForeignKey(name = "fk_logr_endr") 
		)
	@EqualsAndHashCode.Include
	private Logradouro logradouro;
	
	@Column(name = "endr_compl"
			+ "", nullable = true, columnDefinition = "VARCHAR(100)")
	private String complemento;
	
	@Column(name = "endr_num", nullable = true, columnDefinition = "VARCHAR(10)")
	private String numero;
	
	@Convert(converter = UnidadeFederativaConverter.class)
	@Column(name = "enduf", nullable = false, columnDefinition = "INT")
	private UnidadeFederativa unidadeFederativa;
	
	@ManyToMany
	@JoinTable( name = "tb_pes_endr", joinColumns = @JoinColumn(name = "end_id"), inverseJoinColumns = @JoinColumn(name = "pes_id") ) 
	private Set<PessoaFisica> pessoas;
	
	public String getNomeBairro() {
		return this.logradouro.getNomeBairro();
	}
	
	public String getNomeMunicipio() {
		return this.logradouro.getNomeMunicipio();
	}

}
