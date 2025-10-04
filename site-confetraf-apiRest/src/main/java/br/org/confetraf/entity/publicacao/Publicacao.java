package br.org.confetraf.entity.publicacao;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import br.org.confetraf.entity.Auditable;
import br.org.confetraf.entity.usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "tb_pub_publicacao")
public class Publicacao extends Auditable {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pub_seq")
	@SequenceGenerator(name = "pub_seq", sequenceName = "pub_seq", allocationSize = 50)
	public Long pub_id;
	
	@Column(name = "pub_titulo", nullable = false, unique = true, columnDefinition = "VARCHAR(100)" )
	@EqualsAndHashCode.Include
	public String titulo;
	
	@Column(name = "pub_subtitulo", nullable = false, unique = true, columnDefinition = "VARCHAR(200)" )
	public String subTitulo;
	
	@Lob
	@Column(name = "pub_conteudo", nullable = false, columnDefinition = "NVARCHAR(MAX)")
	public String corpo;
	
	@ManyToAny
	@JoinColumn(name = "Pub_cat_id")
	public Categoria categoria;
	
	@Column(name = "pub_ini_publicacao", nullable = false, columnDefinition = "DATETIME")
	public LocalDate dataInicioPublicacao;
	
	@Column(name = "pub_fim_publicacao", nullable = false, columnDefinition = "DATETIME")
	public LocalDate dataFimPublicacao;
	
	@OneToOne
	@JoinColumn(name = "pes_usuario_id", nullable = false)
	public Usuario usuario;
	
	

}
