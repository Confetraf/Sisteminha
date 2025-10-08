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
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=false)
@Table(name = "tb_ibg_mes", uniqueConstraints = {
		@UniqueConstraint(name = "unq_mes_cod", columnNames = {"mes_cod"}),
		@UniqueConstraint(name = "unq_mes_nom", columnNames = {"mes_nom"})
})
public class Mesoregiao extends Auditable implements Serializable {

	private static final long serialVersionUID = 1066863399726162687L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mes_seq")
	@SequenceGenerator(name = "mes_seq", sequenceName = "mes_seq", allocationSize = 50)
	private Long mes_id;
	
	@Convert(converter = UnidadeFederativaConverter.class)
	@Column(name = "mes_uf",  nullable = false, columnDefinition = "INT")
	private UnidadeFederativa unidadeFederativa;
	
	@EqualsAndHashCode.Include
	@Column(name = "mes_cod", nullable = false, columnDefinition = "VARCHAR(2)")
	private String codigo;
	
	@Column(name = "mes_nom", nullable = false, columnDefinition = "VARCHAR(50)")
	private String nome;
	
	@OneToMany(mappedBy = "mesoregiao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Municipio> municipios;
	

}
