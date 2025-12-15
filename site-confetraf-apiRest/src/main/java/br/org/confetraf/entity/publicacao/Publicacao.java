package br.org.confetraf.entity.publicacao;

import java.io.Serializable;
import java.time.LocalDate;

import br.com.thadeugarrido.pessoa_core.entity.Auditable;
import br.org.confetraf.entity.usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "tb_pub_pbl", uniqueConstraints = {
		@UniqueConstraint(name = "unq_pbl_tit", columnNames = {"pbl_tit"})
})
public class Publicacao extends Auditable implements Serializable {
	
	private static final long serialVersionUID = -7408005923676328299L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pbl_seq")
	@SequenceGenerator(name = "pbl_seq", sequenceName = "pbl_seq", allocationSize = 50)
	public Long pbl_id;
	
	@Column(name = "pbl_tit", nullable = false, columnDefinition = "VARCHAR(100)" )
	@EqualsAndHashCode.Include
	public String titulo;
	
	@Column(name = "pbl_subt", nullable = false, columnDefinition = "VARCHAR(100)" )
	public String subTitulo;
	
	@Lob
	@Column(name = "pbl_corp", nullable = false, columnDefinition = "TEXT")
	public String corpo;
	
	@ManyToOne
	@JoinColumn(name = "cat_id",
	foreignKey = @ForeignKey(name = "fk_cat_pbl"))
	public Categoria categoria;
	
	@Column(name = "pbl_ini_dt", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	public LocalDate dataInicioPublicacao;
	
	@Column(name = "pbl_fim_dt", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	public LocalDate dataFimPublicacao;
	
	@ManyToOne
	@JoinColumn(name = "pes_id", nullable = false,
			foreignKey = @ForeignKey(name = "fk_pes_pbl"))
	public Usuario usuario;

}
