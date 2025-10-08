package br.org.confetraf.entity.pessoa;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import br.org.confetraf.entity.enums.TipoDocumento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_pes_fis")
@PrimaryKeyJoinColumn(name = "pes_id",
foreignKey = @ForeignKey(name = "fk_fis_pes") 
)
public abstract class PessoaFisica extends Pessoa implements Serializable {
	
	private static final long serialVersionUID = 4633913360746884956L;
	
	@Column(name = "fis_cin_son")
	private boolean possuiCIN;
	
	
	@Transient
	protected List<TipoDocumento> tiposDocPF(){
		return Arrays.asList(TipoDocumento.CPF, TipoDocumento.NIS, TipoDocumento.RG);
	}
	
	
	

}
