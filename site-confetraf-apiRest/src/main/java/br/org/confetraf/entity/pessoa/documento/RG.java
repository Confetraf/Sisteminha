package br.org.confetraf.entity.pessoa.documento;

import static br.org.confetraf.entity.pessoa.documento.DocumentoUtils.limparNumero;

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
