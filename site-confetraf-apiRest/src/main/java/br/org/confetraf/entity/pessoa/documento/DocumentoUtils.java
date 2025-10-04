package br.org.confetraf.entity.pessoa.documento;

public class DocumentoUtils {
	
	public static final String limparNumero(String numero) {
		return numero.replaceAll("\\D", "");
	}

}
