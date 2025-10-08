package br.org.confetraf.entity.ibge;

import java.io.Serializable;

import br.org.confetraf.entity.converters.UnidadeFederativaConverter;
import br.org.confetraf.entity.enums.UnidadeFederativa;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(name = "tb_ibg_mun", uniqueConstraints = {
		@UniqueConstraint(name = "unq_mun_cod", columnNames = {"mun_cod"}),
		@UniqueConstraint(name = "unq_mun_cod_comp", columnNames = {"mun_cod_comp"})
})
public class Municipio implements Serializable {
	
	private static final long serialVersionUID = -3688325703292736098L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mun_seq")
	@SequenceGenerator(name = "mun_seq", sequenceName = "mun_seq", allocationSize = 50)
	private Long mun_id;
	
	@Column(name = "mun_cod", nullable = false, columnDefinition = "VARCHAR(5)")
	private String codigo;
	
	@EqualsAndHashCode.Include
	@Column(name = "mun_cod_comp", nullable = false, columnDefinition = "VARCHAR(7)")
	private String codigoIbgeCompleto;
	
	@ManyToOne
	@JoinColumn(name = "rgin_id",
	foreignKey = @ForeignKey(name = "fk_rgin_mun"))
	private RegiaoGeograficaIntermediaria regiaoGeograficaIntermediaria;
	
	@ManyToOne
	@JoinColumn(name = "rgi_id",
	foreignKey = @ForeignKey(name = "fk_rgi_mun"))
	private RegiaoGeograficaImediata regiaoGeograficaImediata;
	
	@ManyToOne
	@JoinColumn(name = "mes_id",
	foreignKey = @ForeignKey(name = "fk_mes_mun"))
	private Mesoregiao mesoregiao;
	
	@ManyToOne
	@JoinColumn(name = "mcr_id",
	foreignKey = @ForeignKey(name = "fk_mcr_mun"))
	private Microregiao microregiao;
	
	@Column(name = "mun_nome",  unique = false, nullable = false, columnDefinition = "VARCHAR(150)")
	private String nome;
	
	@Convert(converter = UnidadeFederativaConverter.class)
	@Column(name = "mun_uf",  nullable = false, columnDefinition = "INT")
	private UnidadeFederativa unidadeFederativa;
	
	

}
