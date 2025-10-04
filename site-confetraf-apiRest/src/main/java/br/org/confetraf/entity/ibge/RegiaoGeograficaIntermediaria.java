package br.org.confetraf.entity.ibge;

import java.io.Serializable;

import br.org.confetraf.entity.enums.converters.ibge.UnidadeFederativaConverter;
import br.org.confetraf.entity.enums.ibge.UnidadeFederativa;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity
@Table(name = "TB_REG_GEO_INTERM")
public class RegiaoGeograficaIntermediaria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1364854091340339329L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Convert(converter = UnidadeFederativaConverter.class)
	@Column(name = "REI_UF",  nullable = false, columnDefinition = "INT")
	private UnidadeFederativa unidadeFederativa;
	
	@EqualsAndHashCode.Include
	@Column(name = "REI_CODIGO", unique = true, nullable = false, columnDefinition = "CHAR(4)")
	private String codigo;
	
	@Column(name = "REI_NOME",  unique = true, nullable = false, columnDefinition = "VARCHAR(50)")
	private String nome;
	
	

}
