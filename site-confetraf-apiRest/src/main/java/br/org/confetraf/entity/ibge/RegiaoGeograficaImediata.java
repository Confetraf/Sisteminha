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
@Table(name = "tb_ibg_rgi",
uniqueConstraints = {
		@UniqueConstraint(name = "unq_rgi_cod", columnNames = {"rgi_cod"}),
		@UniqueConstraint(name = "unq_rgi_nom", columnNames = {"rgi_nom"})
})
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=false)
public class RegiaoGeograficaImediata extends Auditable implements Serializable {

	private static final long serialVersionUID = 4328291841398032585L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rgi_seq")
	@SequenceGenerator(name = "rgi_seq", sequenceName = "rgi_seq", allocationSize = 50)
	private Long rgi_id;
	
	@Convert(converter = UnidadeFederativaConverter.class)
	@Column(name = "rgi_uf",  nullable = false, columnDefinition = "INT")
	private UnidadeFederativa unidadeFederativa;
	
	@EqualsAndHashCode.Include
	@Column(name = "rgi_cod", nullable = false, columnDefinition = "VARCHAR(5)")
	private String codigo;
	
	@Column(name = "rgi_nom", nullable = false, columnDefinition = "VARCHAR(50)")
	private String nome;
	
	@OneToMany(mappedBy="regiaoGeograficaImediata", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Municipio> municipios;
	
}
