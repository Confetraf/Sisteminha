package br.org.confetraf.entity.documento;

public class DocumentoUtils {
	
	public static final String limparNumero(String numero) {
		return numero.replaceAll("\\D", "");
	}

}
