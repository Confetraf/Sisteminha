package br.org.confetraf.entity.ibge;

import java.io.Serializable;
import java.util.List;

import br.org.confetraf.entity.Auditable;
import br.org.confetraf.entity.converters.UnidadeFederativaConverter;
import br.org.confetraf.entity.enums.UnidadeFederativa;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Entity
@Table(name = "tb_ibg_rgin", uniqueConstraints = {
		@UniqueConstraint(name = "unq_rgin_cod", columnNames = "rgin_cod"),
		@UniqueConstraint(name = "unq_rgin_nom", columnNames = "rgin_nom")
})
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=false)
public class RegiaoGeograficaIntermediaria extends Auditable implements Serializable {
	
	private static final long serialVersionUID = -1364854091340339329L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rgin_seq")
	@SequenceGenerator(name = "rgin_seq", sequenceName = "rgin_seq", allocationSize = 50)
	private Long rgin_id;
	
	@Convert(converter = UnidadeFederativaConverter.class)
	@Column(name = "rgin_uf",  nullable = false, columnDefinition = "INT")
	private UnidadeFederativa unidadeFederativa;
	
	@EqualsAndHashCode.Include
	@Column(name = "rgin_cod", nullable = false, columnDefinition = "VARCHAR(4)")
	private String codigo;
	
	@Column(name = "rgin_nom", nullable = false, columnDefinition = "VARCHAR(50)")
	private String nome;
	
	@OneToMany(mappedBy = "regiaoGeograficaIntermediaria", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Municipio> municipios;

}
