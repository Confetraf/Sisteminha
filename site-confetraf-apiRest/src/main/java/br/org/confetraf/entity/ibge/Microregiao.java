package br.org.confetraf.entity.ibge;

import java.io.Serializable;
import java.util.List;

import br.org.confetraf.entity.Auditable;
import br.org.confetraf.entity.converters.UnidadeFederativaConverter;
import br.org.confetraf.entity.enums.UnidadeFederativa;
import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=false)
@Table(name = "tb_ibg_mcr", uniqueConstraints = {
		@UniqueConstraint(name = "unq_mcr_cod", columnNames = {"mcr_cod"}),
		@UniqueConstraint(name = "unq_mcr_nom", columnNames = {"mcr_nom"})
})
public class Microregiao extends Auditable implements Serializable {

	private static final long serialVersionUID = -6116349695532642133L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mcr_seq")
	@SequenceGenerator(name = "mcr_seq", sequenceName = "mcr_seq", allocationSize = 50)
	private Long mcr_id;
	
	@Convert(converter = UnidadeFederativaConverter.class)
	@Column(name = "mcr_uf",  nullable = false, columnDefinition = "INT")
	private UnidadeFederativa unidadeFederativa;
	
	@EqualsAndHashCode.Include
	@Column(name = "mcr_cod", nullable = false, columnDefinition = "VARCHAR(3)")
	private String codigo;
	
	@Column(name = "mcr_nom", nullable = false, columnDefinition = "VARCHAR(50)")
	private String nome;
	
	@OneToMany(mappedBy = "microregiao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Municipio> municipios;
	
	

}
