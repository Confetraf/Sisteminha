package br.org.confetraf.entity.endereco;

import java.util.Set;

import br.org.confetraf.entity.Auditable;
import br.org.confetraf.entity.enums.ibge.UnidadeFederativa;
import br.org.confetraf.entity.ibge.Municipio;
import br.org.confetraf.entity.pessoa.Pessoa;
import br.org.confetraf.entity.pessoa.PessoaFisica;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tb_end_logradouro", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"end_log_nome", "end_bai_dis_id"})
    }
)
public class Logradouro extends Auditable {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_seq")
	@SequenceGenerator(name = "log_seq", sequenceName = "log_seq", allocationSize = 50)
	private Long log_id;
	
	@Column(name = "end_log_nome", nullable = false, columnDefinition = "VARCHAR(200)")
	@EqualsAndHashCode.Include
	public String nome;
	
	@ManyToOne
    @JoinColumn(name = "end_bai_dis_id", nullable = false)
	private BairroDistrito bairroDistrito;

}
