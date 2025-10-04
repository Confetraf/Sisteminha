package br.org.confetraf.entity.ibge;

import java.io.Serializable;

import br.org.confetraf.entity.enums.converters.ibge.UnidadeFederativaConverter;
import br.org.confetraf.entity.enums.ibge.UnidadeFederativa;
import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "TB_MICROREGIAO")
public class Microregiao implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Convert(converter = UnidadeFederativaConverter.class)
	@Column(name = "MCG_UF",  nullable = false, columnDefinition = "INT")
	private UnidadeFederativa unidadeFederativa;
	
	@EqualsAndHashCode.Include
	@Column(name = "MCG_CODIGO", unique = true, nullable = false, columnDefinition = "CHAR(3)")
	private String codigo;
	
	@Column(name = "MCG_NOME", unique = true, nullable = false, columnDefinition = "VARCHAR(50)")
	private String nome;
	
	

}
