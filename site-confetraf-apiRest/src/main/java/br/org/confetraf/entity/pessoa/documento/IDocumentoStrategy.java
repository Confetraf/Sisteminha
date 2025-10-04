package br.org.confetraf.entity.pessoa.documento;

public interface IDocumentoStrategy {
	
	default String validarBrancos(String numero) throws IllegalArgumentException {
		if (numero == null|| numero.trim().isEmpty()) throw new IllegalArgumentException("Número do documento não pode ser nulo nem branco!");
		return numero;
	}
	
	String validar(String numero);
	String numeroComMascara(String numero);

}
