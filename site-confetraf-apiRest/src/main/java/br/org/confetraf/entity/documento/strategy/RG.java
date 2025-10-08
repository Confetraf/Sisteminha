package br.org.confetraf.entity.documento.strategy;

import static br.org.confetraf.entity.documento.DocumentoUtils.limparNumero;

public class RG implements IDocumentoStrategy {

	@Override
	public String validar(String numero) {
		return limparNumero(numero);
	}

	@Override
	public String numeroComMascara(String numero) {
		return limparNumero(numero);
	}

}
