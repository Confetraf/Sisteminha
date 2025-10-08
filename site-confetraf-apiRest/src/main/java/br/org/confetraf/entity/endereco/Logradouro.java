package br.org.confetraf.entity.endereco;

import java.io.Serializable;
import br.org.confetraf.entity.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "tb_end_logr", uniqueConstraints = {
        @UniqueConstraint(name = "unq_logr_nom_bai_dis",columnNames = {"logr_nom", "bai_dis_id"})
    }
)
public class Logradouro extends Auditable implements Serializable {
	
	private static final long serialVersionUID = -4758547016127523574L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logr_seq")
	@SequenceGenerator(name = "logr_seq", sequenceName = "logr_seq", allocationSize = 50)
	private Long logr_id;
	
	@Column(name = "logr_nom", nullable = false, columnDefinition = "VARCHAR(200)")
	@EqualsAndHashCode.Include
	public String nome;
	
	@ManyToOne
    @JoinColumn(name = "bai_dis_id", 
    			nullable = false,
    			foreignKey = @ForeignKey(name = "fk_bai_dist_logr"))
	@EqualsAndHashCode.Include
	private BairroDistrito bairroDistrito;
    
    public String getNomeBairro() {
    	return this.bairroDistrito.getNome();
    }
    
    public String getNomeMunicipio() {
    	return this.bairroDistrito.getMunicipio().getNome();
    }

}
