package br.org.confetraf.entity.pessoa.documento;

public interface IDocumento {
	String getSomenteNumeros();
	String getComMascara();
	void setNumeroDocumento(String numero);
}
