package br.org.confetraf.entity.cooperativa;

import java.util.Set;

import br.com.thadeugarrido.pessoa_core.entity.pessoa.PessoaJuridica;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

public class Cooperativa extends PessoaJuridica {

	private static final long serialVersionUID = 2663004961116247113L;
	
	@OneToMany(mappedBy = "cooperativa", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Cooperado> cooperados;
	

}
