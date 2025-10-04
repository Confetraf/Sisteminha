package br.org.confetraf.entity.endereco;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import br.org.confetraf.entity.Auditable;
import br.org.confetraf.entity.enums.converters.ibge.UnidadeFederativaConverter;
import br.org.confetraf.entity.enums.ibge.UnidadeFederativa;
import br.org.confetraf.entity.ibge.Municipio;
import br.org.confetraf.entity.pessoa.PessoaFisica;
import br.org.confetraf.entity.publicacao.Categoria;
import br.org.confetraf.entity.publicacao.Publicacao;
import br.org.confetraf.entity.usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
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
@Table(name = "tb_end_endereco")
public class Endereco extends Auditable implements Serializable {

	private static final long serialVersionUID = 7829486780841849335L;

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "end_seq")
	@SequenceGenerator(name = "end_seq", sequenceName = "end_seq", allocationSize = 50)
	private long end_id;
	
	@Column(name = "end_logradouro", unique = true, nullable = false, columnDefinition = "VARCHAR(150)")
	@EqualsAndHashCode.Include
	private String logradouro;
	
	@Column(name = "end_complemento", nullable = true, columnDefinition = "VARCHAR(100)")
	private String complemento;
	
	@Column(name = "end_numero", nullable = true, columnDefinition = "VARCHAR(10)")
	private String numero;
	
	@Column(name = "end_Bai_Dist", nullable = true, columnDefinition = "VARCHAR(100)")
	private String bairroDistrito;
	
	@Convert(converter = UnidadeFederativaConverter.class)
	@Column(name = "end_uf", nullable = false, columnDefinition = "INT")
	private UnidadeFederativa unidadeFederativa;
	
	@ManyToOne
	@JoinColumn(name = "mun_id")
	@EqualsAndHashCode.Include
	private Municipio municipio;
	
	@ManyToMany
	@JoinTable( name = "tb_pessoa_endereco", joinColumns = @JoinColumn(name = "end_id"), inverseJoinColumns = @JoinColumn(name = "pes_id") ) 
	private Set<PessoaFisica> pessoas;

}
