package br.org.confetraf.entity.pessoa.documento;

import static br.org.confetraf.entity.pessoa.documento.DocumentoUtils.limparNumero;

public class CPF extends Documento implements IDocumentoStrategy {


	private boolean validarDigitosVerificadores(String cpf) {
		try {
			int soma = 0;
			for (int i = 0; i < 9; i++) {
				soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
			}
			int primeiroDigito = (soma * 10) % 11;
			if (primeiroDigito == 10)
				primeiroDigito = 0;
			if (primeiroDigito != Character.getNumericValue(cpf.charAt(9)))
				return false;

			soma = 0;
			for (int i = 0; i < 10; i++) {
				soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
			}
			int segundoDigito = (soma * 10) % 11;
			if (segundoDigito == 10)
				segundoDigito = 0;
			return segundoDigito == Character.getNumericValue(cpf.charAt(10));
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String validar(String numero) throws IllegalArgumentException {
		String apenasNumeros = limparNumero(numero);
		apenasNumeros = validarBrancos(apenasNumeros);
		if (apenasNumeros.length() != 11) throw new IllegalArgumentException("O CPF precisa ter 11 caracteres!");
		if (apenasNumeros.matches("(\\d)\\1{10}")) throw new IllegalArgumentException("Os números do CPF não podem ser todos iguais!");
		if (!validarDigitosVerificadores(apenasNumeros)) throw new IllegalArgumentException("Digito verificador do CPF inválido!");
		return apenasNumeros;
	}

	@Override
	public String numeroComMascara(String numero) {
		return numero.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
	}

}
