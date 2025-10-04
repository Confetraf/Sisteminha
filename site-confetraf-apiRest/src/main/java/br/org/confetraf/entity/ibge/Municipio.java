package br.org.confetraf.entity.ibge;

import java.io.Serializable;

import br.org.confetraf.entity.enums.converters.ibge.UnidadeFederativaConverter;
import br.org.confetraf.entity.enums.ibge.UnidadeFederativa;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
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
@Table(name = "tb_ibg_municipio")
public class Municipio implements Serializable {
	
	private static final long serialVersionUID = -3688325703292736098L;

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mun_seq")
	@SequenceGenerator(name = "mun_seq", sequenceName = "mun_seq", allocationSize = 50)
	private Long mun_id;
	
	@Column(name = "ibg_mun_cod",  unique = true, nullable = false, columnDefinition = "VARCHAR(5)")
	private String codigo;
	
	@EqualsAndHashCode.Include
	@Column(name = "ibg_mun_cod_comp",  unique = true, nullable = false, columnDefinition = "VARCHAR(7)")
	private String codigoIbgeCompleto;
	
	@ManyToOne
	@JoinColumn(name = "rei_id")
	private RegiaoGeograficaIntermediaria regiaoGeograficaIntermediaria;
	
	@ManyToOne
	@JoinColumn(name = "rgi_id")
	private RegiaoGeograficaImediata regiaoGeograficaImediata;
	
	@ManyToOne
	@JoinColumn(name = "mes_id")
	private Mesoregiao mesoregiao;
	@ManyToOne
	@JoinColumn(name = "mcg_id")
	private Microregiao microregiao;
	
	@Column(name = "MUN_NOME",  unique = false, nullable = false, columnDefinition = "VARCHAR(150)")
	private String nome;
	
	@EqualsAndHashCode.Include
	@Convert(converter = UnidadeFederativaConverter.class)
	@Column(name = "MUN_UF",  nullable = false, columnDefinition = "INT")
	private UnidadeFederativa unidadeFederativa;
	
	

}
