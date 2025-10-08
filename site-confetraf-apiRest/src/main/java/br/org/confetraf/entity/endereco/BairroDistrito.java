package br.org.confetraf.entity.endereco;

import java.io.Serializable;
import java.util.List;

import br.org.confetraf.entity.Auditable;
import br.org.confetraf.entity.ibge.Municipio;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tb_end_bai_dis",
    uniqueConstraints = { 
        @UniqueConstraint(name = "unq_end_bai_nom_mun", columnNames = {"bai_dis_nom", "mun_id"})
    }
)

public class BairroDistrito extends Auditable implements Serializable {
	
	private static final long serialVersionUID = 8356827624528943613L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bai_dis_seq")
	@SequenceGenerator(name = "bai_dis_seq", sequenceName = "bai_dis_seq", allocationSize = 50)
	private Long bai_dis_id;
	
	@Column(name = "bai_dis_nom", nullable = false, columnDefinition = "VARCHAR(100)")
	@EqualsAndHashCode.Include
	public String nome;
	
	@ManyToOne
    @JoinColumn(name = "mun_id", 
    		nullable = false,
		    foreignKey = @ForeignKey(name = "fk_mun_bai_dis"))
	private Municipio municipio;
	
	@OneToMany(mappedBy = "bairroDistrito", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Logradouro> logradouros;

}
