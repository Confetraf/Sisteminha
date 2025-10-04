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
@Table(name = "tb_reg_geo_imediata")
public class RegiaoGeograficaImediata implements Serializable {

	private static final long serialVersionUID = 4328291841398032585L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rgi_id;
	
	@Convert(converter = UnidadeFederativaConverter.class)
	@Column(name = "rgi_uf",  nullable = false, columnDefinition = "INT")
	private UnidadeFederativa unidadeFederativa;
	
	@EqualsAndHashCode.Include
	@Column(name = "rgi_codigo",  unique = true, nullable = false, columnDefinition = "CHAR(5)")
	private String codigo;
	
	@Column(name = "rgi_nome", unique = true, nullable = false, columnDefinition = "VARCHAR(50)")
	private String nome;
	
}
