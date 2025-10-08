package br.org.confetraf.entity.pessoa;

public class NomePessoa {
	
	private String nome;
	
	public String getPrimeiroNome() {
        return this.nome.split(" ")[0];
	}
	
	public String getUltimoNome() {
        String[] partes = this.nome.split(" ");
        return partes[partes.length - 1];
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = validarNome(nome);
	}
	
	private String validarNome(String nome) throws IllegalArgumentException {
		if (nome == null) throw new IllegalArgumentException("O nome não pode ser nulo!");
		if (nome.isEmpty()) throw new IllegalArgumentException("O nome não pode ser vazio!");
		if (nome.length()<4) throw new IllegalArgumentException("O nome não pode ter menos que quatro letras!");
		return nome;
	}

}
