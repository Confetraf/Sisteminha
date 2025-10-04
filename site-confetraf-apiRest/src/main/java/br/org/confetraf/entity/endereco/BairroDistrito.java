package br.org.confetraf.entity.endereco;

import br.org.confetraf.entity.ibge.Municipio;
import br.org.confetraf.entity.pessoa.Pessoa;
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
@Table(name = "tb_end_bairro_distrito",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"end_bai_dis_nome", "end_mun_id"})
    }
)

public class BairroDistrito {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bai_dis_seq")
	@SequenceGenerator(name = "bai_dis_seq", sequenceName = "bai_dis_seq", allocationSize = 50)
	private Long end_bai_dis_id;
	
	@Column(name = "end_bai_dis_nome", nullable = false, columnDefinition = "VARCHAR(100)")
	@EqualsAndHashCode.Include
	public String nome;
	
	@ManyToOne
    @JoinColumn(name = "end_mun_id", nullable = false)
	private Municipio municipio;

}
