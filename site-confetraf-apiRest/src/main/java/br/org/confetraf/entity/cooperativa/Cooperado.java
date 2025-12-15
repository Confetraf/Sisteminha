package br.org.confetraf.entity.cooperativa;

import br.com.thadeugarrido.pessoa_core.entity.pessoa.PessoaFisica;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

public class Cooperado extends PessoaFisica {

	private static final long serialVersionUID = 6277624197737936360L;
	
	@OneToMany
	@JoinColumn(name = "pes_jur_coo_id", nullable = false,
	foreignKey = @ForeignKey(name = "fk_pes_jur_coo"))
	private Cooperativa cooperativa;
	
}
