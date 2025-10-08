package br.org.confetraf.entity.publicacao;

import java.io.Serializable;
import java.util.Set;

import br.org.confetraf.entity.Auditable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "tb_pub_cat", uniqueConstraints = {
		@UniqueConstraint(name = "unq_cat_nom", columnNames = {"cat_nom"})
})
public class Categoria extends Auditable implements Serializable {
	
	private static final long serialVersionUID = 4671285170453416778L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_seq")
	@SequenceGenerator(name = "cat_seq", sequenceName = "cat_seq", allocationSize = 50)
	public Long cat_id;
	
	@Column(name = "cat_nom", nullable = false, columnDefinition = "VARCHAR(50)")
	@EqualsAndHashCode.Include
	public String nome;
	
	@Column(name = "cat_descr", nullable = true, columnDefinition = "TEXT")
	public String descricao;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Publicacao> publicacoes;

}
