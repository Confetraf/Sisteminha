package br.org.confetraf.entity.publicacao;

import java.util.Set;

import br.org.confetraf.entity.Auditable;
import br.org.confetraf.entity.enums.ibge.UnidadeFederativa;
import br.org.confetraf.entity.ibge.Municipio;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "tb_pub_categoria")
public class Categoria extends Auditable {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_seq")
	@SequenceGenerator(name = "cat_seq", sequenceName = "cat_seq", allocationSize = 50)
	public Long pub_cat_id;
	
	@Column(name = "pub_cat_nome", unique = true, nullable = false, columnDefinition = "VARCHAR(50)")
	@EqualsAndHashCode.Include
	public String nome;
	
	@Column(name = "pub_cat_descricao", nullable = true, columnDefinition = "VARCHAR(1000)")
	public String descricao;

}
